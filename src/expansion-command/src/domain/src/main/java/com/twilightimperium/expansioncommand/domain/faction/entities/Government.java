package com.twilightimperium.expansioncommand.domain.faction.entities;

import com.twilightimperium.expansioncommand.domain.faction.values.GovernmentId;
import com.twilightimperium.expansioncommand.domain.faction.values.Level;
import com.twilightimperium.expansioncommand.domain.faction.values.Type;
import com.twilightimperium.shared.domain.generic.Entity;

import java.util.List;

public class Government extends Entity<GovernmentId> {
    private Type type;
    private Level level;

    // region Constructors
    public Government(Type type, Level level) {
        super(new GovernmentId());
        this.type = type;
        this.level = level;
    }

    public Government(GovernmentId identity, Type type, Level level) {
        super(identity);
        this.type = type;
        this.level = level;
    }
    // endregion

    // region Getters and Setters
    public Level getLevel() {
        return level;
    }

    public Type getType() {
        return type;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setType(Type type) {
        this.type = type;
    }
    // endregion

    // region Public Methods
    public void increaseLevel(Integer amount) {
        this.level = Level.of(this.level.getValue() + amount);
        this.changeType();
    }

    public void changeType() {
        int currentLevel = this.level.getValue();

        String newType;
        if (currentLevel < 5) {
            newType = "Tribal";
        } else if (currentLevel < 10) {
            newType = "Feudal";
        } else {
            newType = "Imperial";
        }

        this.type = Type.of(newType);
    }
    // endregion
}
