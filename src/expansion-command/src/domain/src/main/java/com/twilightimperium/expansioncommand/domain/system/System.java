package com.twilightimperium.expansioncommand.domain.system;

import com.twilightimperium.expansioncommand.domain.faction.values.FactionId;
import com.twilightimperium.expansioncommand.domain.system.entities.Planet;
import com.twilightimperium.expansioncommand.domain.system.events.InvadingUnitAdded;
import com.twilightimperium.expansioncommand.domain.system.events.InvadingUnitRemoved;
import com.twilightimperium.expansioncommand.domain.system.events.PlanetOwningFactionUpdated;
import com.twilightimperium.expansioncommand.domain.system.events.SystemCreated;
import com.twilightimperium.expansioncommand.domain.system.events.SystemOwningFactionUpdated;
import com.twilightimperium.expansioncommand.domain.system.values.SystemId;
import com.twilightimperium.shared.domain.generic.AggregateRoot;

import java.util.List;

public class System extends AggregateRoot<SystemId> {
    private FactionId factionId;
    private Number number;
    private List<Planet> planetsList;

    // region Constructors
    public System(SystemId identity) {
        super(identity);
    }

    public System(FactionId factionId, Number number, List<Planet> planetsList) {
        super(new SystemId());
        this.factionId = factionId;
        this.number = number;
        this.planetsList = planetsList;
    }
    // endregion

    // region Getters and Setters
    public FactionId getFactionId() {
        return factionId;
    }

    public void setFactionId(FactionId factionId) {
        this.factionId = factionId;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public List<Planet> getPlanetsList() {
        return planetsList;
    }

    public void setPlanetsList(List<Planet> planetsList) {
        this.planetsList = planetsList;
    }
    // endregion

    // region Domain Actions
    public void createSystem(Integer number) {
        apply(new SystemCreated(number));
    }
    
    public void updateSystemOwningFaction(String id) {
        apply(new SystemOwningFactionUpdated(id));
    }

    public void changePlanetOwningFaction(String id, String owningFaction) {
        apply(new PlanetOwningFactionUpdated(id, owningFaction));
    }

    public void addInvadingUnitToPlanet(String type, Integer attackPower, Integer capacity, Integer cost) {
        apply(new InvadingUnitAdded(type, attackPower, capacity, cost));
    }

    public void removeInvadingUnitFromPlanet(String id) {
        apply(new InvadingUnitRemoved(id));
    }
    // endregion

}
