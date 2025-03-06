package com.twilightimperium.expansiondomain.infra.mongo.repositories;

import com.twilightimperium.expansiondomain.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
}
