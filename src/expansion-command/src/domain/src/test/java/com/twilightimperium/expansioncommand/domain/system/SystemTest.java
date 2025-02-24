package com.twilightimperium.expansioncommand.domain.system;

import com.twilightimperium.expansioncommand.domain.system.events.InvadingUnitAdded;
import com.twilightimperium.expansioncommand.domain.system.events.InvadingUnitRemoved;
import com.twilightimperium.expansioncommand.domain.system.events.PlanetAdded;
import com.twilightimperium.expansioncommand.domain.system.events.PlanetOwningFactionUpdated;
import com.twilightimperium.expansioncommand.domain.system.events.SystemCreated;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {
    private System system;

    @BeforeEach
    void setUp() {
        system = new System("The Arborec", 1, List.of("planet1"));
    }

    @Test
    void createSystemSuccessfully() {
        String factionId = "faction123";
        Integer systemNumber = 42;

        System system = new System(factionId, systemNumber, List.of("planet1"));

        assertNotNull(system);
        assertNotNull(system.getNumber());
        assertNotNull(system.getFactionId());

        assertEquals(systemNumber, system.getNumber().getValue());
        assertEquals(factionId, system.getFactionId().getValue());
        assertInstanceOf(SystemCreated.class, system.getUncommittedEvents().get(0));
    }

    @Test
    void addPlanetSuccessfully() {
        String systemId = system.getIdentity().getValue();
        String owningFaction = "faction456";
        Integer resource = 3;
        Integer influence = 2;
        Integer invadingUnits = 1;

        system.addPlanet(owningFaction, resource, influence, invadingUnits);

        assertNotNull(system.getPlanetsList());
        assertEquals(1, system.getPlanetsList().size());

        assertEquals(owningFaction, system.getPlanetsList().get(0).getOwningFaction().getValue());
        assertEquals(resource, system.getPlanetsList().get(0).getResource().getValue());
        assertEquals(influence, system.getPlanetsList().get(0).getInfluence().getValue());
        assertEquals(invadingUnits, system.getPlanetsList().get(0).getInvadingUnitCount().getValue());

        assertInstanceOf(PlanetAdded.class, system.getUncommittedEvents().get(1));
    }

    @Test
    void addPlanetFailed() {
        String systemId = system.getIdentity().getValue();
        String owningFaction = "faction456";

        Object[][] invalidCases = {
                {systemId, owningFaction, -1, 2, 1, "Resource negativo"},
                {systemId, owningFaction, 3, -5, 1, "Influence negativa"},
                {systemId, null, 3, 2, 1, "OwningFaction null"}
        };

        Stream.of(invalidCases).forEach(caseData -> {
            String testCase = (String) caseData[5];

            assertThrows(IllegalArgumentException.class, () ->
                            system.addPlanet((String) caseData[1], (Integer) caseData[2], (Integer) caseData[3], (Integer) caseData[4]),
                    "Falló el caso: " + testCase
            );
        });
    }

    @Test
    void updateSystemOwningFactionSuccessfully() {
        String newFactionId = "faction789";

        system.updateSystemOwningFaction(newFactionId);

        assertEquals(newFactionId, system.getFactionId().getValue());
    }

    @Test
    void addInvadingUnitSuccessfully() {
        system.addPlanet("faction456", 1,1, 1);
        assertEquals(1, system.getPlanetsList().get(0).getInvadingUnitCount().getValue());

        system.addInvadingUnitToPlanet("Infantry");

        assertEquals(2, system.getPlanetsList().get(0).getInvadingUnitCount().getValue());
        assertInstanceOf(PlanetAdded.class, system.getUncommittedEvents().get(1));
    }

    @Test
    void updatePlanetOwningFactionSuccessfully() {
        system.addPlanet("faction456", 3, 2, 1);

        assertFalse(system.getPlanetsList().isEmpty(), "La lista de planetas no debería estar vacía.");

        String planetId = system.getPlanetsList().get(0).getIdentity().getValue();
        assertEquals("faction456", system.getPlanetsList().get(0).getOwningFaction().getValue());

        system.changePlanetOwningFaction(planetId, "faction789");

        assertEquals("faction789", system.getPlanetsList().get(0).getOwningFaction().getValue());
    }

    @Test
    void removeInvadingUnitFromPlanetSuccessfully() {
        system.addPlanet( "faction123", 4, 2, 3);

        assertFalse(system.getPlanetsList().isEmpty(), "La lista de planetas no debería estar vacía.");
        String planetId = system.getPlanetsList().get(0).getIdentity().getValue();
        assertEquals(3, system.getPlanetsList().get(0).getInvadingUnitCount().getValue());

        system.removeInvadingUnitFromPlanet(planetId);

        assertEquals(2, system.getPlanetsList().get(0).getInvadingUnitCount().getValue());

    }

    @Test
    void recreateSystemFromEventsSuccessfully() {
        String systemId = "system123";
        String factionId = "faction789";
        Integer systemNumber = 42;

        List<DomainEvent> events = List.of(
                new SystemCreated(systemNumber, factionId, List.of("planet1")),
                new PlanetAdded("faction456", 4, 2, 3),
                new InvadingUnitAdded("Infantry")
        );

        System recreatedSystem = System.from(systemId, events);

        assertNotNull(recreatedSystem);
        assertEquals(systemId, recreatedSystem.getIdentity().getValue());
        assertEquals(systemNumber, recreatedSystem.getNumber().getValue());
        assertEquals(factionId, recreatedSystem.getFactionId().getValue());

        assertNotNull(recreatedSystem.getPlanetsList());
        assertEquals(1, recreatedSystem.getPlanetsList().size());
        assertEquals(4, recreatedSystem.getPlanetsList().get(0).getInvadingUnitCount().getValue());

        assertEquals(4, recreatedSystem.getPlanetsList().get(0).getInvadingUnitCount().getValue());
    }



}