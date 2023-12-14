package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.entity.Medico;
import com.bootcamp.databases.repository.jpa.MedicoRepository;
import com.bootcamp.databases.service.MedicoService;

@Slf4j
@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repo;

	@Override
	public void registrar(Medico m) throws Exception {
		repo.save(m);

	}

	@Override
	public void modificar(Medico m) throws Exception {
		repo.save(m);

	}

	@Override
	public Medico buscar(int id) throws Exception {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
	}

	@Override
	public Medico buscar(String dni) throws Exception {
		return repo.findByDni(dni);
	}

	@Override
	public List<Medico> listarTodos() throws Exception {
		return repo.findAll();
	}

}
