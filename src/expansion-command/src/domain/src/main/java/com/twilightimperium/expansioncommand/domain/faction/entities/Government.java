package com.twilightimperium.expansioncommand.domain.faction.entities;

import com.twilightimperium.expansioncommand.domain.faction.values.GovernmentId;
import com.twilightimperium.expansioncommand.domain.faction.values.Level;
import com.twilightimperium.expansioncommand.domain.faction.values.Type;
import com.twilightimperium.shared.domain.generic.Entity;

import java.util.List;

public class Government extends Entity<GovernmentId> {
    private Type type;
    private Level level;

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

    public void increaseLevel(Integer amount) {
        this.level = Level.of(this.level.getValue() + amount);
        this.changeType();
    }


    public void changeType() {
        int currentLevel = this.level.getValue();

        List<String> types = List.of("Tribal", "Feudal", "Imperial");

        int index = Math.min((currentLevel - 1) / 5, types.size() - 1);

        this.type = Type.of(types.get(index));
    }

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
}
