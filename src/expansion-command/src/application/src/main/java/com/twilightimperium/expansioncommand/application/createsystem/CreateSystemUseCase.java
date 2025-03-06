package com.twilightimperium.expansioncommand.application.createsystem;

import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.application.shared.system.SystemResponse;
import com.twilightimperium.expansioncommand.domain.system.System;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.twilightimperium.expansioncommand.application.shared.system.SystemMapper.mapSystemToResponse;

public class CreateSystemUseCase implements ICommandUseCase<CreateSystemRequest, Mono<SystemResponse>> {
    private final IEventsRepositoryPort eventRepository;

    public CreateSystemUseCase(IEventsRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<SystemResponse> execute(CreateSystemRequest request) {

        return eventRepository.findEventsByAggregateId(request.getFactionId())
                .collectList()
                .map(events -> {
        System system = new System(
                request.getFactionId(),
                request.getNumber(),
                request.getPlanetsList()
        );


        system.addPlanet("faction1", 1, 1, 1);
        system.addPlanet("faction2", 1, 1, 1);

        system.getUncommittedEvents().forEach(eventRepository::save);
        system.markEventsAsCommitted();

        return mapSystemToResponse(system);

        });
    }
}
