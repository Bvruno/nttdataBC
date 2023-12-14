package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.documents.Examen;
import com.bootcamp.databases.repository.mongo.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen registrar(Examen e) throws Exception {
        return examenRepository.save(e);
    }

    @Override
    public Examen modificar(Examen e) throws Exception {
        return examenRepository.save(e);
    }

    @Override
    public Examen buscar(int id) throws Exception {
        return null;
    }

    @Override
    public Examen buscar(String nombre) throws Exception {
        return null;
    }

    @Override
    public List<Examen> listarTodos() throws Exception {
        return examenRepository.findAll();
    }
}
