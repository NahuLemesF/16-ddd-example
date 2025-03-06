package com.twilightimperium.expansiondomain.infra.mainservice.controllers;

import com.twilightimperium.expansioncommand.application.startbattle.StartBattleRequest;
import com.twilightimperium.expansioncommand.application.startbattle.StartBattleResponse;
import com.twilightimperium.expansioncommand.application.startbattle.StartBattleUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/start-battle")
public class StartBattleController {
    private final StartBattleUseCase useCase;

    public StartBattleController(StartBattleUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<StartBattleResponse> execute(@RequestBody StartBattleRequest request) {
        return useCase.execute(request);
    }
}
