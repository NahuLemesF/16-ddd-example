package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class UnitCreated extends DomainEvent {
    private final String type;
    private final Integer attackPower;
    private final Integer capacity;
    private final Integer cost;

    public UnitCreated(String type, Integer attackPower, Integer capacity, Integer cost) {
        super(EventsEnum.UNIT_CREATED.name());
        this.type = type;
        this.attackPower = attackPower;
        this.capacity = capacity;
        this.cost = cost;
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

    public String getType() {
        return type;
    }
}
