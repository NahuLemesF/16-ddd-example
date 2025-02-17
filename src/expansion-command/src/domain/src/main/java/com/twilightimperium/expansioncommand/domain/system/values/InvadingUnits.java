package com.twilightimperium.expansioncommand.domain.system.values;

import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.shared.domain.generic.IValueObject;
import com.twilightimperium.shared.domain.utils.Validate;

public class InvadingUnits implements IValueObject {
    private final Integer value;

    private InvadingUnits(final Integer value) {
        this.value = value;
        validate();
    }

    public static InvadingUnits of(final Integer value) {
        return new InvadingUnits(value);
    }

    @Override
    public void validate() {
        Validate.validateNotNull(value, "Invading Units");
        Validate.validatePositiveNumber(value, "Invading Units");
    }

    public Integer getValue() {
        return value;
    }
}