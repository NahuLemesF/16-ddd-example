package com.twilightimperium.expansioncommand.application.shared.unit;

public class UnitResponse {
    private final String unitId;
    private final String unitType;
    private final Integer combatPower;
    private final Integer movement;
    private final Integer capacity;
    private final Integer cost;



    public UnitResponse(String unitId, String unitType, Integer combatPower, Integer movement, Integer capacity, Integer cost) {
        this.unitId = unitId;
        this.unitType = unitType;
        this.combatPower = combatPower;
        this.movement = movement;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getUnitId() {
        return unitId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getCombatPower() {
        return combatPower;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getMovement() {
        return movement;
    }

    public String getUnitType() {
        return unitType;
    }
}
