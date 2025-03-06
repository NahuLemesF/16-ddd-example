package com.twilightimperium.expansiondomain.infra.mainservice.config;

import com.twilightimperium.expansiondomain.infra.mongo.adapters.MongoAdapter;
import com.twilightimperium.expansiondomain.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.twilightimperium.expansiondomain.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.twilightimperium.expansiondomain.infra.mongo.repositories")
public class MongoConfig {
    @Bean
    public MongoAdapter mongoAdapter(IEventsRepository repository) {
        return new MongoAdapter(repository);
    }

}
