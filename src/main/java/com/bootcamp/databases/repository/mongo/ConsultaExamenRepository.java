package com.bootcamp.databases.repository.mongo;

import com.bootcamp.databases.model.documents.ConsultaExamen;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConsultaExamenRepository extends MongoRepository<ConsultaExamen, Integer> {
    List<ConsultaExamen> findAllByIdConsulta(int idConsulta);
}
