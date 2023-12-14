package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.entity.Especialidad;
import com.bootcamp.databases.model.entity.Medico;
import com.bootcamp.databases.repository.jpa.EspecialidadRepository;
import com.bootcamp.databases.repository.jpa.MedicoRepository;
import com.bootcamp.databases.service.EspecialidadService;
import com.bootcamp.databases.service.MedicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EspecialidadServiceImpl implements EspecialidadService {

	@Autowired
	private EspecialidadRepository repo;

	@Override
	public void registrar(Especialidad e) throws Exception {
		repo.save(e);

	}

	@Override
	public void modificar(Especialidad e) throws Exception {
		repo.save(e);

	}

	@Override
	public Especialidad buscar(int id) throws Exception {
		Optional<Especialidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialidad();
	}

	@Override
	public List<Especialidad> listarTodos() throws Exception {
		return repo.findAll();
	}

}
