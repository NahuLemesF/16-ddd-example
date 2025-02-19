package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class GovernmentLevelDecreased extends DomainEvent {

    public GovernmentLevelDecreased() {
        super(EventsEnum.GOVERNMENT_LEVEL_DECREASED.name());
    }

}
