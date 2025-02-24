package com.twilightimperium.expansioncommand.application.startbattle;

import com.twilightimperium.shared.application.Request;

public class StartBattleRequest extends Request {
    private final String unitId;
    private final String unitType;
    private final String targetId;
    private final String planetId;
    private final Integer percentage;

    protected StartBattleRequest(String aggregateId, String unitId, String unitType, String targetId, String planetId, Integer percentage) {
        super(aggregateId);
        this.unitId = unitId;
        this.unitType = unitType;
        this.targetId = targetId;
        this.planetId = planetId;
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

}
