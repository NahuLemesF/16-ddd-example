package com.twilightimperium.expansioncommand.application.createunit;

import com.twilightimperium.shared.application.Request;

public class CreateUnitRequest extends Request {
    private String unitType;
    private Integer combatPower;
    private Integer movement;
    private Integer capacity;
    private Integer cost;

    protected CreateUnitRequest(String aggregateId, String unitType, Integer combatPower, Integer movement, Integer capacity, Integer cost) {
        super(aggregateId);
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
