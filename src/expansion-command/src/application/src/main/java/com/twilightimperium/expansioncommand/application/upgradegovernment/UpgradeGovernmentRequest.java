package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.shared.application.Request;

public class UpgradeGovernmentRequest extends Request {
    private final String unitId;
    private final Integer additionalCapacity;
    private final Integer reducedCost;
    private final Integer governmentLevel;

    public UpgradeGovernmentRequest(String aggregateId, String unitId, Integer additionalCapacity, Integer reducedCost, Integer governmentLevel) {
        super(aggregateId);
        this.unitId = unitId;
        this.additionalCapacity = additionalCapacity;
        this.reducedCost = reducedCost;
        this.governmentLevel = governmentLevel;
    }

    public String getUnitId() {
        return unitId;
    }

    public Integer getAdditionalCapacity() {
        return additionalCapacity;
    }

    public Integer getReducedCost() {
        return reducedCost;
    }

    public Integer getGovernmentLevel() {
        return governmentLevel;
    }
}
