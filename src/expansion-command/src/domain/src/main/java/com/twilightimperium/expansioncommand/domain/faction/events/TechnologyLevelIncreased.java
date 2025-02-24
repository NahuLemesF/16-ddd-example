package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class TechnologyLevelIncreased extends DomainEvent {
    private final String name;
    private final Integer level;

    public TechnologyLevelIncreased(String name, Integer level) {
        super(EventsEnum.TECHNOLOGY_LEVEL_INCREASED.name());
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }
}
