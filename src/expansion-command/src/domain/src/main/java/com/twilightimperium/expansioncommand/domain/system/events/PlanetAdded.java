package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class PlanetAdded extends DomainEvent {
    private String owningFaction;
    private Integer resource;
    private Integer influence;
    private Integer invadingUnits;

    public PlanetAdded() {
        super(null);
    }

    public PlanetAdded(String owningFaction, Integer resource, Integer influence, Integer invadingUnits) {
        super(EventsEnum.PLANET_ADDED.name());
        this.owningFaction = owningFaction;
        this.resource = resource;
        this.influence = influence;
        this.invadingUnits = invadingUnits;
    }

    public String getOwningFaction() {
        return owningFaction;
    }

    public Integer getResource() {
        return resource;
    }

    public Integer getInfluence() {
        return influence;
    }

    public Integer getInvadingUnits() {
        return invadingUnits;
    }

    public void setOwningFaction(String owningFaction) {
        this.owningFaction = owningFaction;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public void setInvadingUnits(Integer invadingUnits) {
        this.invadingUnits = invadingUnits;
    }

    public void setResource(Integer resource) {
        this.resource = resource;
    }
}
