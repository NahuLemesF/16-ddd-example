package com.twilightimperium.expansioncommand.application.createfaction;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.ports.IEventsRepositoryPort;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

import static com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper.mapFactionToResponse;

public class CreateFactionUseCase implements ICommandUseCase<CreateFactionRequest, Mono<FactionResponse>> {
    private final IEventsRepositoryPort eventRepository;

    public CreateFactionUseCase(IEventsRepositoryPort eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<FactionResponse> execute(CreateFactionRequest request) {
        Faction faction = new Faction(
                request.getName(),
                request.getDescription(),
                request.getSurrendered(),
                request.getGovernmentType(),
                request.getGovernmentLevel(),
                request.getTechnologiesList()
        );
        Stream.of("Technology 1", "Technology 2").forEach(tech -> faction.addTechnology(tech, 1));

        faction.getUncommittedEvents().forEach(eventRepository::save);
        faction.markEventsAsCommitted();

        return Mono.just(mapFactionToResponse(faction));
    }
}
