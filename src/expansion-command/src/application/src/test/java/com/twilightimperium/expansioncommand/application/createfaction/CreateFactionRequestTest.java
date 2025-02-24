package com.twilightimperium.expansioncommand.application.createfaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateFactionRequestTest {
    private CreateFactionRequest request;

    @BeforeEach
    void setUp() {
        List<String> technologies = Arrays.asList("Tech 1", "Tech 2");
        request = new CreateFactionRequest(
                "Faction Name",
                "Description",
                false,
                "Democracy",
                5,
                technologies
        );
    }

    @Test
    void testGetName() {
        assertEquals("Faction Name", request.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("Description", request.getDescription());
    }

    @Test
    void testGetSurrendered() {
        assertFalse(request.getSurrendered());
    }

    @Test
    void testGetGovernmentType() {
        assertEquals("Democracy", request.getGovernmentType());
    }

    @Test
    void testGetGovernmentLevel() {
        assertEquals(5, request.getGovernmentLevel());
    }

    @Test
    void testGetTechnologiesList() {
        List<String> expectedTechnologies = Arrays.asList("Tech 1", "Tech 2");
        assertEquals(expectedTechnologies, request.getTechnologiesList());
    }

    @Test
    void testWithReactor() {
        Mono<CreateFactionRequest> requestMono = Mono.just(request);

        StepVerifier.create(requestMono)
                .assertNext(r -> {
                    assertEquals("Faction Name", r.getName());
                    assertEquals("Description", r.getDescription());
                    assertFalse(r.getSurrendered());
                    assertEquals("Democracy", r.getGovernmentType());
                    assertEquals(5, r.getGovernmentLevel());
                    assertEquals(2, r.getTechnologiesList().size());
                    assertTrue(r.getTechnologiesList().contains("Tech 1"));
                })
                .verifyComplete();
    }
}
