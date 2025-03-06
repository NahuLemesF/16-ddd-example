package com.twilightimperium.expansiondomain.infra.mainservice.controllers;

import com.twilightimperium.expansioncommand.application.createfaction.CreateFactionRequest;
import com.twilightimperium.expansioncommand.application.createfaction.CreateFactionUseCase;
import com.twilightimperium.expansioncommand.application.shared.faction.FactionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-faction")
public class CreateFactionController {
    private final CreateFactionUseCase useCase;

    public CreateFactionController(CreateFactionUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<FactionResponse> execute(@RequestBody CreateFactionRequest request) {
        return useCase.execute(request);
    }
}
