package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.events.GovernmentLevelIncreased;
import com.twilightimperium.expansioncommand.domain.faction.events.TechnologyLevelIncreased;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class UpgradeGovernmentUseCaseTest {

    private IEventRepository eventRepository;
    private UpgradeGovernmentUseCase useCase;

    @BeforeEach
    void setUp() {
        eventRepository = mock(IEventRepository.class);
        useCase = new UpgradeGovernmentUseCase(eventRepository);
    }

    @Test
    void execute_shouldUpgradeGovernmentLevel_andChangeType_andIncreaseTechnology() {
        // Arrange
        String aggregateId = "faction-123";
        String unitId = "unit-456";
        String technologyName = "Tech-789";
        int governmentLevel = 5;
        int additionalCapacity = 2;
        int reducedCost = 1;
        int technologyLevel = 3;

        List<DomainEvent> events = List.of(
                new GovernmentLevelIncreased(),
                new TechnologyLevelIncreased(technologyName, technologyLevel)
        );

        when(eventRepository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(events));

        UpgradeGovernmentRequest request = new UpgradeGovernmentRequest(
                aggregateId, unitId, governmentLevel, additionalCapacity, reducedCost, technologyName, technologyLevel
        );

        // Act & Assert
        StepVerifier.create(useCase.execute(request))
                .expectNextMatches(response -> {
                    // Verifica las propiedades del response
                    return response.getGovernmentLevel() == governmentLevel &&
                            response.getTechnologiesList().stream()
                                    .anyMatch(t -> t.getName().equals(technologyName) && t.getLevel().equals(technologyLevel));
                })
                .verifyComplete();

        // Verificación de los métodos llamados
        verify(eventRepository, times(1)).findEventsByAggregateId(aggregateId);
        verify(eventRepository, times(1)).save(any(DomainEvent.class));
    }
}
