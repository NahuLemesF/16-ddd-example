package com.twilightimperium.expansioncommand.application.upgradegovernment;

import com.twilightimperium.shared.application.Request;

public class UpgradeGovernmentRequest extends Request {
    private final String unitId;
    private final Integer additionalCapacity;
    private final Integer reducedCost;
    private final Integer governmentLevel;
    private final String technologyName;
    private final Integer technologyLevel;

    public UpgradeGovernmentRequest(String aggregateId, String unitId, Integer additionalCapacity, Integer reducedCost, Integer governmentLevel, String technologyName, Integer technologyLevel) {
        super(aggregateId);
        this.unitId = unitId;
        this.additionalCapacity = additionalCapacity;
        this.reducedCost = reducedCost;
        this.governmentLevel = governmentLevel;
        this.technologyName = technologyName;
        this.technologyLevel = technologyLevel;
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

    public String getTechnologyName() {
        return technologyName;
    }

    public Integer getTechnologyLevel() {
        return technologyLevel;
    }
}
