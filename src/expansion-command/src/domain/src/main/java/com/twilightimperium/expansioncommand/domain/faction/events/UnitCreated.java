package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class UnitCreated extends DomainEvent {
    private String type;
    private Integer combatPower;
    private Integer movement;
    private Integer capacity;
    private Integer cost;

    public UnitCreated() {
        super(null);
    }

    public UnitCreated(String type, Integer combatPower, Integer movement, Integer capacity, Integer cost) {
        super(EventsEnum.UNIT_CREATED.name());
        this.type = type;
        this.combatPower = combatPower;
        this.movement = movement;
        this.capacity = capacity;
        this.cost = cost;
    }

    public Integer getCombatPower() {
        return combatPower;
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

    public Integer getMovement() {
        return movement;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setCombatPower(Integer combatPower) {
        this.combatPower = combatPower;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }

    public void setType(String type) {
        this.type = type;
    }
}
