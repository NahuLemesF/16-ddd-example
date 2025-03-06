package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper;
import com.twilightimperium.expansioncommand.application.shared.system.SystemMapper;
import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.expansioncommand.domain.system.System;
import com.twilightimperium.shared.application.ICommandUseCase;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public class StartBattleUseCase implements ICommandUseCase<StartBattleRequest, Mono<StartBattleResponse>> {
    private final IEventsRepositoryPort eventRepository;

    public StartBattleUseCase(IEventsRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<StartBattleResponse> execute(StartBattleRequest request) {
        Mono<List<DomainEvent>> factionEvents = eventRepository.findEventsByAggregateId(request.getAggregateId()).collectList();
        Mono<List<DomainEvent>> systemEvents = eventRepository.findEventsByAggregateId(request.getPlanetId()).collectList();

        return Mono.zip(factionEvents, systemEvents)
                .map(tuple -> {
                    Faction faction = Faction.from(request.getAggregateId(), tuple.getT1());
                    System system = System.from(request.getPlanetId(), tuple.getT2());

                    system.addInvadingUnitToPlanet(request.getUnitId());
                    faction.removeUnit(request.getUnitId());
                    faction.addConqueredFaction(system.getFactionId().getValue(), request.getPercentage());

                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    system.getUncommittedEvents().forEach(eventRepository::save);

                    faction.markEventsAsCommitted();
                    system.markEventsAsCommitted();

                    return new StartBattleResponse(
                            SystemMapper.mapSystemToResponse(system),
                            FactionMapper.mapFactionToResponse(faction)
                    );
                });
    }
}
