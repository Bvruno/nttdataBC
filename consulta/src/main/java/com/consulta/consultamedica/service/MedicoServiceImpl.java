package com.consulta.consultamedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.consulta.consultamedica.dao.MedicoRepository;
import com.consulta.consultamedica.model.Medico;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoRepository repo;
	
	@Override
	public void registrar(Medico m) {
		repo.save(m);
		
	}

	@Override
	public Medico buscar(int id) {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
	}

}
