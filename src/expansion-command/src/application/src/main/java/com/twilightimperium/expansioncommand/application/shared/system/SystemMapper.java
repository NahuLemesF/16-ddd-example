package com.twilightimperium.expansioncommand.application.shared.system;

import com.twilightimperium.expansioncommand.domain.system.System;

import java.util.stream.Collectors;

public class SystemMapper {
    public static SystemResponse mapSystemToResponse(System system) {
        return new SystemResponse(
                system.getIdentity().getValue(),
                system.getFactionId().getValue(),
                system.getNumber().getValue(),
                system.getPlanetsList().stream().map(planet -> new SystemResponse.Planet(
                        planet.getIdentity().getValue(),
                        planet.getOwningFaction().getValue(),
                        planet.getResource().getValue(),
                        planet.getInfluence().getValue(),
                        planet.getInvadingUnitCount().getValue()
                )).collect(Collectors.toList())
        );
    }
}
