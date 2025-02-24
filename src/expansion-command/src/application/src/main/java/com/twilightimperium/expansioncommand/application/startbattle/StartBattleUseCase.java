package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper;
import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.expansioncommand.domain.system.System;
import com.twilightimperium.expansioncommand.domain.system.entities.Planet;
import com.twilightimperium.expansioncommand.domain.system.events.InvadingUnitRemoved;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.Optional;

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

                    Optional<Planet> planet = system.getPlanetsList().stream()
                            .filter(p -> p.getIdentity().getValue().equals(request.getPlanetId()))
                            .findFirst();

                    planet.ifPresent(p -> {
                        if (p.getInvadingUnitCount().getValue() > 0) {
                            if (request.getUnitType().equals("PowerfulUnit")) {
                                system.removeInvadingUnitFromPlanet(request.getPlanetId());
                            } else {
                                system.addInvadingUnitToPlanet(request.getUnitType());
                            }
                        }
                        faction.updateConqueredFactionPercentage(request.getTargetId(), request.getPercentage());
                    });

                    faction.getUncommittedEvents().forEach(eventRepository::save);
                    faction.markEventsAsCommitted();

                    return FactionMapper.mapFactionToResponse(faction);
                });
    }
}
