package com.twilightimperium.expansioncommand.domain.faction;

import com.twilightimperium.expansioncommand.domain.faction.entities.ConqueredFaction;
import com.twilightimperium.expansioncommand.domain.faction.events.FactionCreated;
import com.twilightimperium.expansioncommand.domain.faction.events.FactionSurrendered;
import com.twilightimperium.expansioncommand.domain.faction.events.GovernmentLevelIncreased;
import com.twilightimperium.expansioncommand.domain.faction.events.UnitCreated;
import com.twilightimperium.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactionTest {
    private Faction faction;

    @BeforeEach
    void setUp() {
        faction = new Faction("The Arborec", "New Faction", false, "Tribal", 1, List.of( "Technology 1", "Technology 2"));
    }

    @Test
    void createFactionSuccessfully() {
        assertEquals("The Arborec", faction.getName().getValue());
        assertEquals("New Faction", faction.getDescription().getValue());
        assertFalse(faction.getIsSurrendered().getValue());
        assertNotNull(faction.getGovernment());
        assertEquals("Tribal", faction.getGovernment().getType().getValue());
        assertEquals(1, faction.getGovernment().getLevel().getValue());
        assertNotNull(faction.getUnitsList());
        assertEquals(0, faction.getUnitsList().size());
        assertNotNull(faction.getTechnologiesList());
        assertEquals(0, faction.getTechnologiesList().size());
        assertNotNull(faction.getConqueredFactionsList());
        assertEquals(0, faction.getConqueredFactionsList().size());
        assertInstanceOf(FactionCreated.class, faction.getUncommittedEvents().get(0));
    }

    @Test
    void createFactionFailed() {
        assertThrows(IllegalArgumentException.class, () -> new Faction("", "", false, "", 0, List.of( "Technology 1", "Technology 2")));
    }

    @Test
    void createUnitSuccessfully() {
        faction.createUnit("Infantry", 1, 1, 4, 1);
        faction.createUnit("Caza", 9, 1, 1, 2);
        assertEquals(2, faction.getUnitsList().size());
        assertInstanceOf(UnitCreated.class, faction.getUncommittedEvents().get(1));
    }

    @Test
    void createUnitFailed() {
        assertThrows(IllegalArgumentException.class, () -> faction.createUnit("", 0, 0, 0, 0));
    }

    @Test
    void removeUnitSuccessfully() {
        faction.createUnit("Infantry", 1, 1, 4, 1);
        faction.createUnit("Caza", 9, 1, 1, 2);

        String unitId = faction.getUnitsList().get(0).getIdentity().getValue();

        faction.removeUnit(unitId);

        assertEquals(1, faction.getUnitsList().size());
    }

    @Test
    void increaseUnitCapacitySuccess() {
        faction.createUnit("Infantry", 1, 1, 4, 1);
        String unitId = faction.getUnitsList().get(0).getIdentity().getValue();

        faction.increaseUnitCapacity(unitId, 2);

        assertEquals(6, faction.getUnitsList().get(0).getCapacity().getValue());
    }

    @Test
    void reduceUnitCostSuccessfully() {
        faction.createUnit("Infantry", 1, 1, 4, 4);
        String unitId = faction.getUnitsList().get(0).getIdentity().getValue();

        faction.reduceUnitCost(unitId, 1);

        assertEquals(3, faction.getUnitsList().get(0).getCost().getValue());
    }

    @Test
    void addTechnologySuccessfully() {
        faction.addTechnology("Technology 1", 1);
        faction.addTechnology("Technology 2", 2);

        assertEquals(2, faction.getTechnologiesList().size());
    }

    @Test
    void increaseTechnologyLevelSuccessfully() {
        faction.addTechnology("Technology 1", 1);
        faction.addTechnology("Technology 2", 2);

        faction.increaseTechnologyLevel(" Technology 1",1);

        assertEquals(2, faction.getTechnologiesList().get(0).getLevel().getValue());
    }

    @Test
    void increaseGovernmentLevelSuccessfully() {
        faction.increaseGovernmentLevel();
        assertEquals(2, faction.getGovernment().getLevel().getValue());
    }

    @Test
    void governmentTypeChangesWithLevel() {
        assertEquals("Tribal", faction.getGovernment().getType().getValue());

        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();

        faction.changeGovernmentType("Feudal", 5);
        assertEquals("Feudal", faction.getGovernment().getType().getValue());

        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();
        faction.increaseGovernmentLevel();

        assertEquals("Imperial", faction.getGovernment().getType().getValue());
    }
    @Test
    void addConqueredFactionSuccessfully() {
        assertNotNull(faction.getConqueredFactionsList());

        faction.addConqueredFaction("The Emirates of Hacan", 50);
        assertEquals(1, faction.getConqueredFactionsList().size());

        ConqueredFaction firstFaction = faction.getConqueredFactionsList().get(0);
        assertEquals("The Emirates of Hacan", firstFaction.getName().getValue());
        assertEquals(50, firstFaction.getPercentage().getValue());

        faction.addConqueredFaction("The Federation of Sol", 75);
        assertEquals(2, faction.getConqueredFactionsList().size());

        ConqueredFaction secondFaction = faction.getConqueredFactionsList().get(1);
        assertEquals("The Federation of Sol", secondFaction.getName().getValue());
        assertEquals(75, secondFaction.getPercentage().getValue());

        assertEquals(3, faction.getUncommittedEvents().size());
    }

    @Test
    void addConqueredFactionFailed() {
        assertThrows(IllegalArgumentException.class, () -> faction.addConqueredFaction("", 30));
        assertThrows(IllegalArgumentException.class, () -> faction.addConqueredFaction("The Naalu Collective", -10));

    }

    @Test
    void removeConqueredFactionSuccessfully() {
        faction.addConqueredFaction("The Emirates of Hacan", 50);
        faction.addConqueredFaction("The Federation of Sol", 75);

        String factionId = faction.getConqueredFactionsList().get(0).getIdentity().getValue();

        faction.removeConqueredFaction(factionId);

        assertEquals(1, faction.getConqueredFactionsList().size());
    }

    @Test
    void updateConqueredFactionPercentageSuccessfully() {
        faction.addConqueredFaction("The Arborec Subjugated", 10);
        String factionId = faction.getConqueredFactionsList().get(0).getIdentity().getValue();

        int conqueredSystems = 7;
        faction.updateConqueredFactionPercentage(factionId, conqueredSystems);

        assertEquals(80, faction.getConqueredFactionsList().get(0).getPercentage().getValue());
    }

    @Test
    void surrenderFactionSuccessfully() {
        assertFalse(faction.getIsSurrendered().getValue());

        faction.surrender(true);

        assertTrue(faction.getIsSurrendered().getValue());
    }

    @Test
    void recreateFactionFromEventsSuccessfully() {
        String factionId = "faction-123";
        List<DomainEvent> events = List.of(
                new FactionCreated("The Arborec", "New Faction", false, "Tribal", 1, List.of( "Technology 1", "Technology 2")),
                new GovernmentLevelIncreased(),
                new FactionSurrendered(false)
        );

        Faction reconstructedFaction = Faction.from(factionId, events);

        assertEquals(factionId, reconstructedFaction.getIdentity().getValue());
        assertEquals("The Arborec", reconstructedFaction.getName().getValue());
        assertEquals("New Faction", reconstructedFaction.getDescription().getValue());
        assertFalse(reconstructedFaction.getIsSurrendered().getValue());
        assertEquals("Tribal", reconstructedFaction.getGovernment().getType().getValue());
        assertEquals(2, reconstructedFaction.getGovernment().getLevel().getValue());
    }

}