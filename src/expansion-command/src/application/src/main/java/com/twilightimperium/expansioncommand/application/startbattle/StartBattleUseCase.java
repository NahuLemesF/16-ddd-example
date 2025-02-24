package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper;
import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.expansioncommand.domain.system.System;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;


public class StartBattleUseCase implements ICommandUseCase<StartBattleRequest, Mono<FactionResponse>> {
    private final IEventRepository eventRepository;

    public StartBattleUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<FactionResponse> execute(StartBattleRequest request) {
        return eventRepository
                .findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Faction faction = Faction.from(request.getAggregateId(), events);
                    System system = System.from(request.getPlanetId(), events);

                    system.addInvadingUnitToPlanet(request.getUnitId());
                    faction.removeUnit(request.getUnitId());
                    faction.addConqueredFaction(system.getFactionId().getValue(), request.getPercentage());


                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    system.getUncommittedEvents().forEach(eventRepository::save);

                    faction.markEventsAsCommitted();
                    system.markEventsAsCommitted();

                    return FactionMapper.mapFactionToResponse(faction);
                });
    }
}

// Estudiar Metodo Zip.

