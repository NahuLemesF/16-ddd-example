package com.twilightimperium.expansioncommand.domain.faction.entities;

import com.twilightimperium.expansioncommand.domain.faction.values.AttackPower;
import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.expansioncommand.domain.faction.values.Cost;
import com.twilightimperium.expansioncommand.domain.faction.values.Type;
import com.twilightimperium.expansioncommand.domain.faction.values.UnitId;
import com.twilightimperium.shared.domain.generic.Entity;

public class Unit extends Entity<UnitId> {
    private Type type;
    private AttackPower attackPower;
    private Capacity capacity;
    private Cost cost;

    public Unit(AttackPower attackPower, Capacity capacity, Cost cost, Type type) {
        super(new UnitId());
        this.attackPower = attackPower;
        this.capacity = capacity;
        this.cost = cost;
        this.type = type;
    }

    public Unit(UnitId identity, AttackPower attackPower, Capacity capacity, Cost cost, Type type) {
        super(identity);
        this.attackPower = attackPower;
        this.capacity = capacity;
        this.cost = cost;
        this.type = type;
    }

    public void increaseCapacity() {
        this.capacity = Capacity.of(this.capacity.getValue() + 2);
    }

    public void reduceCost(int amount) {
        int newCostValue = Math.max(1, this.cost.getValue() - amount);
        this.cost = Cost.of(newCostValue);
    }

    public AttackPower getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(AttackPower attackPower) {
        this.attackPower = attackPower;
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
}
