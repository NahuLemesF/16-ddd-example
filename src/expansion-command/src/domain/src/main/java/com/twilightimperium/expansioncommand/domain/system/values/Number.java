package com.twilightimperium.expansioncommand.domain.system.values;

import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.shared.domain.generic.IValueObject;
import com.twilightimperium.shared.domain.utils.Validate;

public class Number implements IValueObject {
    private final Integer value;

    private Number(final Integer value) {
        this.value = value;
        validate();
    }

    public static Number of(final Integer value) {
        return new Number(value);
    }

    @Override
    public void validate() {
        Validate.validateNotNull(value, "Number");
        Validate.validatePositiveNumber(value, "Number");
    }

    public Integer getValue() {
        return value;
    }
}
