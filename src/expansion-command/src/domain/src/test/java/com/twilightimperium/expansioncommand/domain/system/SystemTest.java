package com.twilightimperium.expansioncommand.domain.system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {
    private System system;

    @BeforeEach
    void setUp() {
        system = new System("The Arborec", 1);
    }

    @Test
    void createSystemSuccessfully() {
        assertEquals("The Arborec", system.getFactionId().getValue());
        assertEquals(1, system.getNumber().getValue());
    }


}