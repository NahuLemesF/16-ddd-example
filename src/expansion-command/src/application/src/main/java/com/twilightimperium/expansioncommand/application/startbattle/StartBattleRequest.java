package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.shared.application.Request;

public class StartBattleRequest extends Request {
    private final String unitId;
    private final String unitType;
    private final String targetId;
    private final String planetId;
    private final String aggregateIdSystem;
    private final Integer percentage;

    protected StartBattleRequest(String aggregateId, String unitId, String unitType, String targetId, String planetId, String aggregateIdSystem, Integer percentage) {
        super(aggregateId);
        this.unitId = unitId;
        this.unitType = unitType;
        this.targetId = targetId;
        this.planetId = planetId;
        this.aggregateIdSystem = aggregateIdSystem;
        this.percentage = percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public String getPlanetId() {
        return planetId;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getUnitType() {
        return unitType;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getAggregateIdSystem() {
        return aggregateIdSystem;
    }
}
