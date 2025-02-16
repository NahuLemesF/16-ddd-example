package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class InvadingUnitAdded extends DomainEvent {
    private final String type;
    private final Integer attackPower;
    private final Integer capacity;
    private final Integer cost;

    public InvadingUnitAdded(String type, Integer attackPower, Integer capacity, Integer cost) {
        super(EventsEnum.INVADING_UNIT_ADDED.name());
        this.type = type;
        this.attackPower = attackPower;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public Integer getAttackPower() {
        return attackPower;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getCost() {
        return cost;
    }
}
