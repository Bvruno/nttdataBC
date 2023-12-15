package com.consulta.consultamedica.service;

import org.springframework.stereotype.Service;

import com.consulta.consultamedica.model.Medico;

public interface MedicoService {

	public void registrar(Medico m);
	public Medico buscar(int id);
}
