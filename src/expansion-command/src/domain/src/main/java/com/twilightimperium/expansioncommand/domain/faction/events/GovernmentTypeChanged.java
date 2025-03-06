package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class GovernmentTypeChanged extends DomainEvent {
    private String type;
    private Integer level;

    public GovernmentTypeChanged(String name) {
        super(name);
    }

    public GovernmentTypeChanged(String type, Integer level) {
        super(EventsEnum.GOVERNMENT_TYPE_CHANGED.name());
        this.type = type;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }
}
