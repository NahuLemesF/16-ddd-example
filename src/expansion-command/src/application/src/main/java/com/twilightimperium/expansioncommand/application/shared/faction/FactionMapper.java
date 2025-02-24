package com.twilightimperium.expansioncommand.application.shared.faction;

import com.twilightimperium.expansioncommand.domain.faction.Faction;

import java.util.stream.Collectors;

public class FactionMapper {
    public static FactionResponse mapFactionToResponse(Faction faction) {
        return new FactionResponse(
                faction.getIdentity().getValue(),
                faction.getName().getValue(),
                faction.getDescription().getValue(),
                faction.getIsSurrendered().getValue(),
                faction.getGovernment().getType().getValue(),
                faction.getGovernment().getLevel().getValue(),
                faction.getConqueredFactionsList().stream().map(cf -> new FactionResponse.ConqueredFaction(cf.getIdentity().getValue(), cf.getName().getValue(), cf.getPercentage().getValue())).collect(Collectors.toList()),
                faction.getUnitsList().stream().map(u -> new FactionResponse.Unit(u.getIdentity().getValue(), u.getType(), u.getAttackPower(), u.getMovement(), u.getCapacity(), u.getCost())).collect(Collectors.toList()),
                faction.getTechnologiesList().stream().map(t -> new FactionResponse.Technology(t.getIdentity().getValue(), t.getName().getValue(), t.getLevel().getValue())).collect(Collectors.toList())
        );
    }
}
