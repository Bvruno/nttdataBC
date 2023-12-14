package com.bootcamp.databases.service;

import com.bootcamp.databases.model.documents.ConsultaExamen;

import java.util.List;

public interface ConsultaExamenService {
    List<ConsultaExamen> listarTodos();

    ConsultaExamen listarPorConsultaAndExamen(ConsultaExamen consultaExamen);

    List<ConsultaExamen> listarPorPaciente(String idPaciente);

    List<ConsultaExamen> listarPorMedico(String idMedico);

    ConsultaExamen registrar(ConsultaExamen ce);

    List<ConsultaExamen> listarPorConsulta(String idConsulta);
}
