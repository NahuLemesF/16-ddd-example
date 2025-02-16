package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class GovernmentLevelIncreased extends DomainEvent {
    private final String type;
    private final Integer level;

    public GovernmentLevelIncreased(String type, Integer level) {
        super(EventsEnum.GOVERNMENT_LEVEL_INCREASED.name());
        this.type = type;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }
}
