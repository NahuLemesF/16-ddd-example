package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class TechnologyLevelIncreased extends DomainEvent {
    private final String id;
    private final Integer level;

    public TechnologyLevelIncreased(String id, Integer level) {
        super(EventsEnum.TECHNOLOGY_LEVEL_INCREASED.name());
        this.id = id;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public String getId() {
        return id;
    }
}
