package com.twilightimperium.expansioncommand.application.shared.faction;

import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.expansioncommand.domain.faction.values.CombatPower;
import com.twilightimperium.expansioncommand.domain.faction.values.Cost;
import com.twilightimperium.expansioncommand.domain.faction.values.Movement;
import com.twilightimperium.expansioncommand.domain.faction.values.Type;

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
        private final Type type;
        private final CombatPower combatPower;
        private final Movement movement;
        private final Capacity capacity;
        private final Cost cost;

        public Unit(String id, Type type, CombatPower combatPower, Movement movement, Capacity capacity, Cost cost) {
            this.id = id;
            this.type = type;
            this.combatPower = combatPower;
            this.movement = movement;
            this.capacity = capacity;
            this.cost = cost;
        }

        // region Getters
        public String getId() {
            return id;
        }

        public Capacity getCapacity() {
            return capacity;
        }

        public CombatPower getCombatPower() {
            return combatPower;
        }

        public Cost getCost() {
            return cost;
        }

        public Movement getMovement() {
            return movement;
        }

        public Type getType() {
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
