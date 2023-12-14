package com.bootcamp.databases.repository.mongo;


import com.bootcamp.databases.model.documents.Examen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamenRepository extends MongoRepository<Examen, Integer> {
}
