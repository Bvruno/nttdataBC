package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.entity.Medico;

public interface MedicoService {
	
	void registrar(Medico m) throws Exception;
	
	void modificar(Medico m) throws Exception;
	
	Medico buscar(int id) throws Exception;
	Medico buscar(String dni) throws Exception;
	
	List<Medico> listarTodos() throws Exception;

}
