package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper;
import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.shared.application.ICommandUseCase;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper.mapFactionToResponse;

public class UpgradeGovernmentUseCase implements ICommandUseCase<UpgradeGovernmentRequest, Mono<FactionResponse>> {
    private final IEventRepository eventRepository;

    public UpgradeGovernmentUseCase(IEventRepository eventRepository) {
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

                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    faction.markEventsAsCommitted();

                    return mapFactionToResponse(faction);
                });
    }
}
