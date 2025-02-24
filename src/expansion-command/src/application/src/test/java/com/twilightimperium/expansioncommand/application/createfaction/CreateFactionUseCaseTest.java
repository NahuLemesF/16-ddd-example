package com.twilightimperium.expansioncommand.application.createfaction;

import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import com.twilightimperium.expansioncommand.application.shared.repositories.IEventRepository;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateFactionUseCaseTest {
    private IEventRepository eventRepository;
    private CreateFactionUseCase createFactionUseCase;

    public CreateFactionUseCaseTest() {
        eventRepository = mock(IEventRepository.class);
        createFactionUseCase = new CreateFactionUseCase(eventRepository);
    }

    @Test
    void execute_shouldCreateFaction_andSaveEvents() {
        List<String> technologies = Arrays.asList("Tech 1", "Tech 2");
        CreateFactionRequest request = new CreateFactionRequest(
                "Faction Name",
                "Description",
                false,
                "Tribal",
                5,
                technologies
        );

        Mono<FactionResponse> responseMono = createFactionUseCase.execute(request);

        StepVerifier.create(responseMono)
                .assertNext(response -> {
                    assertEquals("Faction Name", response.getName());
                    assertEquals("Description", response.getDescription());
                    assertFalse(response.getSurrendered());
                    assertEquals("Tribal", response.getGovernmentType());
                    assertEquals(1, response.getGovernmentLevel());
                    assertEquals(2, response.getTechnologiesList().size());
                })
                .verifyComplete();

        verify(eventRepository, times(3)).save(any());
    }
}
