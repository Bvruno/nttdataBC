package com.bootcamp.databases.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.documents.DetalleConsulta;

public interface DetalleConsultaRepository extends MongoRepository<DetalleConsulta, Integer> {

}
