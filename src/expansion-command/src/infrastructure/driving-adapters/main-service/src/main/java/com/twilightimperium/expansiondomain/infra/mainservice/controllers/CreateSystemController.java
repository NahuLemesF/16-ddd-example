package com.twilightimperium.expansiondomain.infra.mainservice.controllers;

import com.twilightimperium.expansioncommand.application.createsystem.CreateSystemRequest;
import com.twilightimperium.expansioncommand.application.createsystem.CreateSystemUseCase;
import com.twilightimperium.expansioncommand.application.shared.system.SystemResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-system")
public class CreateSystemController {
    private final CreateSystemUseCase useCase;

    public CreateSystemController(CreateSystemUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<SystemResponse> execute(@RequestBody CreateSystemRequest request) {
        return useCase.execute(request);
    }
}
