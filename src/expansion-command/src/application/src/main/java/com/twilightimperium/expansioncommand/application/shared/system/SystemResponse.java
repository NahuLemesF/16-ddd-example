package com.twilightimperium.expansioncommand.application.shared.system;

import java.util.List;

public class SystemResponse {
    private final String systemId;
    private final String factionId;
    private final Integer number;
    private final List<Planet> planetsList;

    public SystemResponse(String systemId, String factionId, Integer number, List<Planet> planetsList) {
        this.systemId = systemId;
        this.factionId = factionId;
        this.number = number;
        this.planetsList = planetsList;
    }

    // region Getters


    public String getFactionId() {
        return factionId;
    }

    public Integer getNumber() {
        return number;
    }

    public List<Planet> getPlanetsList() {
        return planetsList;
    }

    public String getSystemId() {
        return systemId;
    }

    // endregion

    public static class Planet {
        private final String id;
        private final String owningFaction;
        private final Integer resource;
        private final Integer influence;
        private final Integer invadingUnitCount;

        public Planet(String id, String owningFaction, Integer resource, Integer influence, Integer invadingUnitCount) {
            this.id = id;
            this.owningFaction = owningFaction;
            this.resource = resource;
            this.influence = influence;
            this.invadingUnitCount = invadingUnitCount;
        }

        // region Getters

        public String getId() {
            return id;
        }

        public Integer getInfluence() {
            return influence;
        }

        public Integer getInvadingUnitCount() {
            return invadingUnitCount;
        }

        public String getOwningFaction() {
            return owningFaction;
        }

        public Integer getResource() {
            return resource;
        }


        // endregion
    }
}
