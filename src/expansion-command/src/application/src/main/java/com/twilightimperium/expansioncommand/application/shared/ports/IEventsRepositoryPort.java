package com.twilightimperium.expansioncommand.application.shared.ports;

import com.twilightimperium.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepositoryPort {
    Flux<DomainEvent> findAllAggregates();
    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    void save(DomainEvent event);
}
