package com.twilightimperium.expansioncommand.application.startbattle;


import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.system.SystemResponse;

public class StartBattleResponse {
    private final SystemResponse systemResponse;
    private final FactionResponse factionResponse;

    public StartBattleResponse(SystemResponse systemResponse, FactionResponse factionResponse) {
        this.systemResponse = systemResponse;
        this.factionResponse = factionResponse;
    }

    public SystemResponse getSystemResponse() {
        return systemResponse;
    }

    public FactionResponse getFactionResponse() {
        return factionResponse;
    }
}
