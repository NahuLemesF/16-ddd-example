package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class TechnologyLevelIncreased extends DomainEvent {
    private String techName;
    private Integer level;

    public TechnologyLevelIncreased(String techName) {
        super(techName);
    }

    public TechnologyLevelIncreased(String techName, Integer level) {
        super(EventsEnum.TECHNOLOGY_LEVEL_INCREASED.name());
        this.techName = techName;
        this.level = level;
    }

    public String getFactionName() {
        return techName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
