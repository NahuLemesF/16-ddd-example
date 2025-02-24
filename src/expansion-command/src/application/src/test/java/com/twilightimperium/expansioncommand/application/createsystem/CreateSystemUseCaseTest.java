package com.twilightimperium.expansioncommand.application.createsystem;

import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.system.events.PlanetAdded;
import com.twilightimperium.expansioncommand.domain.system.events.SystemCreated;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CreateSystemUseCaseTest {
    private final CreateSystemUseCase useCase;
    private final IEventRepository repository;

    public CreateSystemUseCaseTest() {
        repository = Mockito.mock(IEventRepository.class);
        useCase = new CreateSystemUseCase(repository);
    }

    @Test
    void executeSuccessfully() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new SystemCreated(50, "factionId", List.of("Planet 1", "Planet 2")),
                new PlanetAdded("factionId", 2, 1, 0)));
        CreateSystemRequest request = new CreateSystemRequest(50, "factionId", List.of("Planet 1", "Planet 2"));

        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("factionId", response.getFactionId());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }

}