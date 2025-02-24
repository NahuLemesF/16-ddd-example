package com.twilightimperium.expansioncommand.domain.faction.entities;

import com.twilightimperium.expansioncommand.domain.faction.values.CombatPower;
import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.expansioncommand.domain.faction.values.Cost;
import com.twilightimperium.expansioncommand.domain.faction.values.Movement;
import com.twilightimperium.expansioncommand.domain.faction.values.Type;
import com.twilightimperium.expansioncommand.domain.faction.values.UnitId;
import com.twilightimperium.shared.domain.generic.Entity;

public class Unit extends Entity<UnitId> {
    private Type type;
    private CombatPower combatPower;
    private Movement movement;
    private Capacity capacity;
    private Cost cost;
    private static final Integer CAPACITY_INCREMENT = 2;

    // region Constructors
    public Unit(Integer combatPower, Integer capacity, Integer cost, String type, Integer movement) {
        super(new UnitId());
        this.combatPower = CombatPower.of(combatPower);
        this.capacity = Capacity.of(capacity);
        this.cost = Cost.of(cost);
        this.type = Type.of(type);
        this.movement = Movement.of(movement);
    }

    public Unit(UnitId identity, Integer combatPower, Integer capacity, Integer cost, String type, int movement) {
        super(identity);
        this.combatPower = CombatPower.of(combatPower);
        this.capacity = Capacity.of(capacity);
        this.cost = Cost.of(cost);
        this.type = Type.of(type);
        this.movement = Movement.of(movement);
    }
    // endregion

    // endregion

    // region Getters and Setters
    public CombatPower getAttackPower() {
        return combatPower;
    }

    public void setAttackPower(CombatPower combatPower) {
        this.combatPower = combatPower;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    // endregion

    // region Public Methods
    public void increaseCapacity() {
        this.capacity = Capacity.of(this.capacity.getValue() + CAPACITY_INCREMENT);
    }

    public void reduceCost(int amount) {
        int newCostValue = Math.max(1, this.cost.getValue() - amount);
        this.cost = Cost.of(newCostValue);
    }
    // endregion

}
