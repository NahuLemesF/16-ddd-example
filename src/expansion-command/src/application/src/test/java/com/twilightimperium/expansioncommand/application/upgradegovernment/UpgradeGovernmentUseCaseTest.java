package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.domain.faction.events.FactionCreated;
import com.twilightimperium.expansioncommand.domain.faction.events.GovernmentLevelIncreased;
import com.twilightimperium.expansioncommand.domain.faction.events.GovernmentTypeChanged;
import com.twilightimperium.expansioncommand.domain.faction.events.TechnologyLevelIncreased;
import com.twilightimperium.expansioncommand.domain.faction.events.UnitCapacityIncreased;
import com.twilightimperium.expansioncommand.domain.faction.events.UnitCostReduced;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class UpgradeGovernmentUseCaseTest {
    private IEventsRepositoryPort eventRepository;
    private UpgradeGovernmentUseCase useCase;

    public UpgradeGovernmentUseCaseTest() {
        eventRepository = mock(IEventsRepositoryPort.class);
        useCase = new UpgradeGovernmentUseCase(eventRepository);
    }

    @Test
    void executeSuccessfully() {
        Mockito.when(eventRepository.findEventsByAggregateId(Mockito.anyString())).thenReturn(Flux.just(
                new FactionCreated("factionId", "description", false, "governmentType", 1, List.of("Tech 1", "Tech 2")),
                new GovernmentLevelIncreased(),
                new GovernmentTypeChanged("Tribal", 6),
                new UnitCapacityIncreased("unitId", 2),
                new UnitCostReduced("unitId", 1),
                new TechnologyLevelIncreased("factionId", 1)));
        UpgradeGovernmentRequest request = new UpgradeGovernmentRequest("factionId", "unitId", 2, 1, 1, "Tech 1", 2);

        StepVerifier
                .create(useCase.execute(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertEquals("factionId", response.getFactionId());
                })
                .verifyComplete();
    }
}
