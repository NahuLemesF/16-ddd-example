package com.twilightimperium.expansioncommand.application.createfaction;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import com.twilightimperium.expansioncommand.domain.faction.Faction;
import com.twilightimperium.shared.application.ICommandUseCase;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.twilightimperium.expansioncommand.application.shared.faction.FactionMapper.mapFactionToResponse;

public class CreateFactionUseCase implements ICommandUseCase<CreateFactionRequest, Mono<FactionResponse>> {
    private final IEventRepository eventRepository;

    public CreateFactionUseCase(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Mono<FactionResponse> execute(CreateFactionRequest request) {
        Faction faction = new Faction(
                request.getName(),
                request.getDescription(),
                request.getSurrendered(),
                request.getGovernmentType(),
                request.getGovernmentLevel()
        );
       faction.getUncommittedEvents().forEach(eventRepository::save);
       faction.markEventsAsCommitted();

        return Mono.just(mapFactionToResponse(faction));
    }
}
