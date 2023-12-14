package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.documents.DetalleConsulta;
import com.bootcamp.databases.repository.mongo.DetalleConsultaRepository;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService {

    @Autowired
    private DetalleConsultaRepository detalleConsultaRepository;

    @Override
    public DetalleConsulta registrar(DetalleConsulta d) {
        return detalleConsultaRepository.save(d);
    }

    @Override
    public List<DetalleConsulta> listarTodos() {
        return detalleConsultaRepository.findAll();
    }
}
