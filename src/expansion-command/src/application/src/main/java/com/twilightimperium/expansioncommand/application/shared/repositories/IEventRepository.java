package com.twilightimperium.expansioncommand.application.shared.repositories;

import com.twilightimperium.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventRepository {
    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    void save(DomainEvent event);
}
