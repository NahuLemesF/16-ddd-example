package com.twilightimperium.expansioncommand.domain.faction.values;

import com.twilightimperium.shared.domain.generic.IValueObject;
import com.twilightimperium.shared.domain.utils.Validate;

public class AttackPower implements IValueObject {
    private final Integer combat;
    private final Integer movement;

    private AttackPower(final Integer combat, final Integer movement) {
        this.combat = combat;
        this.movement = movement;
        validate();
    }

    public static AttackPower of(final Integer combat, final Integer movement) {
        return new AttackPower(combat, movement);
    }

    @Override
    public void validate() {
        Validate.validateNotNull(combat, "Combat Power");
        Validate.validateNotNull(movement, "Movement Power");
        Validate.validatePositiveNumber(combat, "Combat Power");
        Validate.validatePositiveNumber(movement, "Movement Power");
    }

    public Integer getCombat() {
        return combat;
    }

    public Integer getMovement() {
        return movement;
    }
}
