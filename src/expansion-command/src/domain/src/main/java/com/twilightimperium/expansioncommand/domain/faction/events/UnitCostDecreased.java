package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class UnitCostDecreased extends DomainEvent {
    private final String id;
    private final Integer cost;

    public UnitCostDecreased(String id, Integer cost) {
        super(EventsEnum.UNIT_COST_DECREASED.name());
        this.id = id;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getId() {
        return id;
    }
}
