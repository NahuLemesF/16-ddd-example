package com.twilightimperium.expansioncommand.application.createunit;

import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.events.FactionCreated;
import com.twilightimperium.expansioncommand.domain.faction.events.UnitCreated;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateUnitUseCaseTest {
    private final CreateUnitUseCase useCase;
    private final IEventRepository repository;

    public CreateUnitUseCaseTest() {
        repository = Mockito.mock(IEventRepository.class);
        useCase = new CreateUnitUseCase(repository);
    }

    @Test
    void executeSuccessfullyCreatesUnit() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new FactionCreated("faction1", "description", false, "governmentType", 1, List.of("Tech 1", "Tech 2")),
                new UnitCreated("infantry", 2, 1, 2, 1)
        ));
        CreateUnitRequest request = new CreateUnitRequest("aggregateId", "infantry", 2, 1, 2, 1);

        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("infantry", response.getUnitType());
                    assertEquals(2, response.getCombatPower());
                    assertEquals(1, response.getMovement());
                    assertEquals(2, response.getCapacity());
                    assertEquals(1, response.getCost());
                })
                .verifyComplete();


        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

}