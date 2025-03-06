package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper.mapFactionToResponse;

public class UpgradeGovernmentUseCase implements ICommandUseCase<UpgradeGovernmentRequest, Mono<FactionResponse>> {
    private final IEventsRepositoryPort eventRepository;

    public UpgradeGovernmentUseCase(IEventsRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<FactionResponse> execute(UpgradeGovernmentRequest request) {
        return eventRepository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Faction faction = Faction.from(request.getAggregateId(), events);

                    faction.increaseGovernmentLevel();
                    faction.changeGovernmentType(faction.getGovernment().getType().getValue(), request.getGovernmentLevel());
                    faction.increaseUnitCapacity(request.getUnitId(), request.getAdditionalCapacity());
                    faction.reduceUnitCost(request.getUnitId(), request.getReducedCost());
                    faction.increaseTechnologyLevel(request.getTechnologyName(), request.getTechnologyLevel());

                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    faction.markEventsAsCommitted();

                    return mapFactionToResponse(faction);
                });
    }
}
