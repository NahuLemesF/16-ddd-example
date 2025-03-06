package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class InvadingUnitRemoved extends DomainEvent {
    private String id;

    public InvadingUnitRemoved() {
        super(null);
    }

    public InvadingUnitRemoved(String id) {
        super(EventsEnum.INVADING_UNIT_REMOVED.name());
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
