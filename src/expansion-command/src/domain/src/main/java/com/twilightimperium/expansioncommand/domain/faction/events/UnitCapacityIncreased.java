package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class UnitCapacityIncreased extends DomainEvent {
    private String id;
    private Integer capacity;

    public UnitCapacityIncreased(String name) {
        super(name);
    }

    public UnitCapacityIncreased(String id, Integer capacity) {
        super(EventsEnum.UNIT_CAPACITY_INCREASED.name());
        this.id = id;
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
