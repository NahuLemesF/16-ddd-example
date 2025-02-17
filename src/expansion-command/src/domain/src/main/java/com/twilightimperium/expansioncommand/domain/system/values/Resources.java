package com.twilightimperium.expansioncommand.domain.system.values;

import com.twilightimperium.expansioncommand.domain.faction.values.Capacity;
import com.twilightimperium.shared.domain.generic.IValueObject;
import com.twilightimperium.shared.domain.utils.Validate;

public class Resources implements IValueObject {
    private final Integer value;

    private Resources(final Integer value) {
        this.value = value;
        validate();
    }

    public static Resources of(final Integer value) {
        return new Resources(value);
    }

    @Override
    public void validate() {
        Validate.validateNotNull(value, "Resources");
        Validate.validatePositiveNumber(value, "Resources");
    }

    public Integer getValue() {
        return value;
    }
}
