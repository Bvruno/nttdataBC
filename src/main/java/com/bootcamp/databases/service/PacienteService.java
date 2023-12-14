package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.entity.Paciente;

public interface PacienteService {
	
	public void registrar(Paciente p) throws Exception;
	
	public void modificar(Paciente p) throws Exception;
	
	public Paciente buscar(int id) throws Exception;
	
	public List<Paciente> listarTodos() throws Exception;

}
