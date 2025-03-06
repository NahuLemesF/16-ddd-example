package com.twilightimperium.expansioncommand.application.shared.faction;

import java.util.List;

public class FactionResponse {
    private final String factionId;
    private final String name;
    private final String description;
    private final Boolean isSurrendered;
    private final String governmentType;
    private final Integer governmentLevel;
    private final List<ConqueredFaction> conqueredFactionsList;
    private final List<Unit> unitsList;
    private final List<Technology> technologiesList;

    public FactionResponse(String factionId, String name, String description, Boolean isSurrendered, String governmentType, Integer governmentLevel, List<ConqueredFaction> conqueredFactionsList, List<Unit> unitsList, List<Technology> technologiesList) {
        this.factionId = factionId;
        this.name = name;
        this.description = description;
        this.isSurrendered = isSurrendered;
        this.governmentType = governmentType;
        this.governmentLevel = governmentLevel;
        this.conqueredFactionsList = conqueredFactionsList;
        this.unitsList = unitsList;
        this.technologiesList = technologiesList;
    }

    // region Getters
    public List<ConqueredFaction> getConqueredFactionsList() {
        return conqueredFactionsList;
    }

    public String getDescription() {
        return description;
    }

    public String getFactionId() {
        return factionId;
    }

    public Integer getGovernmentLevel() {
        return governmentLevel;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public Boolean getSurrendered() {
        return isSurrendered;
    }

    public String getName() {
        return name;
    }

    public List<Unit> getUnitsList() {
        return unitsList;
    }

    public List<Technology> getTechnologiesList() {
        return technologiesList;
    }
    // endregion

    public static class Unit {
        private final String id;
        private final String type;
        private final Integer combatPower;
        private final Integer movement;
        private final Integer capacity;
        private final Integer cost;

        public Unit(String id, String type, Integer combatPower, Integer movement, Integer capacity, Integer cost) {
            this.id = id;
            this.type = type;
            this.combatPower = combatPower;
            this.movement = movement;
            this.capacity = capacity;
            this.cost = cost;
        }


        // region Getters

        public Integer getCapacity() {
            return capacity;
        }

        public Integer getCombatPower() {
            return combatPower;
        }

        public Integer getCost() {
            return cost;
        }

        public String getId() {
            return id;
        }

        public Integer getMovement() {
            return movement;
        }

        public String getType() {
            return type;
        }

        // endregion
    }

    public static class ConqueredFaction {
        private final String id;
        private final String name;
        private final Integer percentage;

        public ConqueredFaction(String id, String name, Integer percentage) {
            this.id = id;
            this.name = name;
            this.percentage = percentage;
        }

        // region Getters
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getPercentage() {
            return percentage;
        }
        // endregion
    }

    public static class Technology {
        private final String id;
        private final String name;
        private final Integer level;

        public Technology(String id, String name, Integer level) {
            this.id = id;
            this.name = name;
            this.level = level;
        }

        // region Getters
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getLevel() {
            return level;
        }
        // endregion
    }
}
