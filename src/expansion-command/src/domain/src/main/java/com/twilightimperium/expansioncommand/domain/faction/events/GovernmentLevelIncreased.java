package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class GovernmentLevelIncreased extends DomainEvent {

    public GovernmentLevelIncreased() {
        super(EventsEnum.GOVERNMENT_LEVEL_INCREASED.name());
    }


}
