package com.twilightimperium.expansioncommand.application.createunit;

import com.twilightimperium.shared.application.Request;

public class CreateUnitRequest extends Request {
    private final String unitType;
    private final Integer combatPower;
    private final Integer movement;
    private final Integer capacity;
    private final Integer cost;

    public CreateUnitRequest(String unitType, Integer combatPower, Integer movement, Integer capacity, Integer cost) {
        super(null);
        this.unitType = unitType;
        this.combatPower = combatPower;
        this.movement = movement;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getUnitType() {
        return unitType;
    }

    public Integer getCombatPower() {
        return combatPower;
    }

    public Integer getMovement() {
        return movement;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getCost() {
        return cost;
    }
}
