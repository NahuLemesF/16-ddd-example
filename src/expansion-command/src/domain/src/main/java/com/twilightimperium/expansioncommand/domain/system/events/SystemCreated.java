package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class SystemCreated extends DomainEvent {
    private final Integer number;

    public SystemCreated(Integer number) {
        super(EventsEnum.SYSTEM_CREATED.name());
        this.number = number;
    }
}
