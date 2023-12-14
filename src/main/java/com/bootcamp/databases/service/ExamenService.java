package com.bootcamp.databases.service;

import com.bootcamp.databases.model.documents.Examen;

import java.util.List;

public interface ExamenService {

    Examen registrar(Examen e) throws Exception;

    Examen modificar(Examen e) throws Exception;

    Examen buscar(int id) throws Exception;
    Examen buscar(String nombre) throws Exception;

    List<Examen> listarTodos() throws Exception;
}
