package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.documents.ConsultaExamen;
import com.bootcamp.databases.model.entity.Consulta;
import com.bootcamp.databases.model.entity.Paciente;
import com.bootcamp.databases.repository.jpa.ConsultaRepository;
import com.bootcamp.databases.repository.jpa.PacienteRepository;
import com.bootcamp.databases.repository.mongo.ConsultaExamenRepository;
import com.bootcamp.databases.service.ConsultaExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {

    @Autowired
    private ConsultaExamenRepository consultaExamenRepository;
    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public List<ConsultaExamen> listarTodos() {
        return consultaExamenRepository.findAll();
    }

    @Override
    public ConsultaExamen listarPorConsultaAndExamen(ConsultaExamen consultaExamen) {
        return null;
    }

    @Override
    public List<ConsultaExamen> listarPorPaciente(String idPaciente) {
        List<Consulta> ListConsulta = consultaRepository.findAllByPacienteDni(idPaciente);
        List<ConsultaExamen> listConsultaExamen = new ArrayList<>();
        if(!ListConsulta.isEmpty()) {
            for (Consulta consulta : ListConsulta) {
                List<ConsultaExamen> result = consultaExamenRepository.findAllByIdConsulta(consulta.getIdConsulta());
                listConsultaExamen.addAll(result);
            }
            return listConsultaExamen;
        } else
            return null;
    }

    @Override
    public List<ConsultaExamen> listarPorMedico(String idMedico) {
        List<Consulta> ListConsulta = consultaRepository.findAllByMedicoDni(idMedico);
        List<ConsultaExamen> listConsultaExamen = new ArrayList<>();
        if(!ListConsulta.isEmpty()) {
            for (Consulta consulta : ListConsulta) {
                List<ConsultaExamen> result = consultaExamenRepository.findAllByIdConsulta(consulta.getIdConsulta());
                listConsultaExamen.addAll(result);
            }
            return listConsultaExamen;
        } else
            return null;
    }

    @Override
    public ConsultaExamen registrar(ConsultaExamen ce) {
        return consultaExamenRepository.save(ce);
    }

    @Override
    public List<ConsultaExamen> listarPorConsulta(String idConsulta) {
        return null;
    }
}
