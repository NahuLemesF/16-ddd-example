package com.twilightimperium.expansioncommand.application.createsystem;

import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.application.shared.system.SystemResponse;
import com.twilightimperium.expansioncommand.domain.system.System;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

import static com.twilightimperium.expansioncommand.application.shared.system.SystemMapper.mapSystemToResponse;

public class CreateSystemUseCase implements ICommandUseCase<CreateSystemRequest, Mono<SystemResponse>> {
    private final IEventRepository eventRepository;

    public CreateSystemUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<SystemResponse> execute(CreateSystemRequest request) {
        System system = new System(
                request.getFactionId(),
                request.getNumber(),
                request.getPlanetsList()
        );
        system.addPlanet("faction1", 1, 1, 1);
        system.addPlanet("faction2", 1, 1, 1);

        system.getUncommittedEvents().forEach(eventRepository::save);
        system.markEventsAsCommitted();

        return Mono.just(mapSystemToResponse(system));
    }
}
