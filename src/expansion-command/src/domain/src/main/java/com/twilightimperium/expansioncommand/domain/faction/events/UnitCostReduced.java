package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class UnitCostReduced extends DomainEvent {
    private String id;
    private Integer cost;

    public UnitCostReduced(String name) {
        super(name);
    }

    public UnitCostReduced(String id, Integer cost) {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
