package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.events.FactionCreated;
import com.twilightimperium.expansioncommand.domain.system.events.SystemCreated;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StartBattleUseCaseTest {
    private final StartBattleUseCase useCase;
    private final IEventRepository repository;

    public StartBattleUseCaseTest() {
        repository = Mockito.mock(IEventRepository.class);
        useCase = new StartBattleUseCase(repository);
    }

    @Test
    void executeSuccessfullyStartsBattle() {
        Mockito.when(repository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new FactionCreated("faction1", "description", false, "governmentType", 1, List.of("Tech 1", "Tech 2")),
                new SystemCreated(50, "factionId", List.of("Planet 1", "Planet 2"))
        ));
        StartBattleRequest request = new StartBattleRequest("faction1", "planetId", "unitId", "unitType", "unitName", 50);

        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("faction1", response.getFactionId());
                })
                .verifyComplete();

        Mockito.verify(repository).findEventsByAggregateId(Mockito.anyString());
    }
}