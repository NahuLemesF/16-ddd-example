package com.twilightimperium.expansiondomain.infra.mainservice.controllers;

import com.twilightimperium.expansioncommand.application.createunit.CreateUnitRequest;
import com.twilightimperium.expansioncommand.application.createunit.CreateUnitUseCase;
import com.twilightimperium.expansioncommand.application.shared.unit.UnitResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-unit")
public class CreateUnitController {
    private final CreateUnitUseCase useCase;

    public CreateUnitController(CreateUnitUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<UnitResponse> execute(@RequestBody CreateUnitRequest request) {
        return useCase.execute(request);
    }
}
