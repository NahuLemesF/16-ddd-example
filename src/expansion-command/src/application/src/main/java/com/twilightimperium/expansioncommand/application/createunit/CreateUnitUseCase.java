package com.twilightimperium.expansioncommand.application.createunit;

import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.application.shared.unit.UnitResponse;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class CreateUnitUseCase implements ICommandUseCase<CreateUnitRequest, Mono<UnitResponse>> {
    private final IEventsRepositoryPort eventRepository;

    public CreateUnitUseCase(IEventsRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<UnitResponse> execute(CreateUnitRequest request) {
        return eventRepository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Faction faction = Faction.from(request.getAggregateId(), events);

                    faction.createUnit(
                            request.getUnitType(),
                            request.getCombatPower(),
                            request.getMovement(),
                            request.getCapacity(),
                            request.getCost()
                    );

                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    faction.markEventsAsCommitted();

                    return new UnitResponse(
                            request.getAggregateId(),
                            request.getUnitType(),
                            request.getCombatPower(),
                            request.getMovement(),
                            request.getCapacity(),
                            request.getCost()
                    );
                });
    }
}
