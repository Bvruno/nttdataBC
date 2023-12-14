package com.bootcamp.databases.service;

import com.bootcamp.databases.model.documents.DetalleConsulta;

import java.util.List;

public interface DetalleConsultaService {
    DetalleConsulta registrar(DetalleConsulta d);

    List<DetalleConsulta> listarTodos();
}
