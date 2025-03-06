package com.twilightimperium.expansiondomain.infra.mainservice.config;

import com.twilightimperium.expansioncommand.application.createfaction.CreateFactionUseCase;
import com.twilightimperium.expansioncommand.application.createsystem.CreateSystemUseCase;
import com.twilightimperium.expansioncommand.application.createunit.CreateUnitUseCase;
import com.twilightimperium.expansioncommand.application.startbattle.StartBattleUseCase;
import com.twilightimperium.expansioncommand.application.upgradegovernment.UpgradeGovernmentUseCase;
import com.twilightimperium.expansiondomain.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateFactionUseCase createFactionUseCase(MongoAdapter adapter) {
        return new CreateFactionUseCase(adapter);
    }

    @Bean
    public CreateSystemUseCase createSystemUseCase(MongoAdapter adapter) {
        return new CreateSystemUseCase(adapter);
    }

    @Bean
    public CreateUnitUseCase createUnitUseCase(MongoAdapter adapter) {
        return new CreateUnitUseCase(adapter);
    }

    @Bean
    public UpgradeGovernmentUseCase upgradeGovernmentUseCase(MongoAdapter adapter) {
        return new UpgradeGovernmentUseCase(adapter);
    }

    @Bean
    public StartBattleUseCase startBattleUseCase(MongoAdapter adapter) {
        return new StartBattleUseCase(adapter);
    }
}
