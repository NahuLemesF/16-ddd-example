package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class GovernmentLevelIncreased extends DomainEvent {

    public GovernmentLevelIncreased(String aggregateId) {
        super(EventsEnum.GOVERNMENT_LEVEL_INCREASED.name());
        setAggregateRootId(aggregateId);
    }
}
