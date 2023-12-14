package com.bootcamp.databases.service;

import com.bootcamp.databases.model.ConsultaRequest;
import com.bootcamp.databases.model.entity.Consulta;

import java.util.List;

public interface ConsultaService {
	
	Consulta registrar(Consulta c) throws Exception;
	Consulta registrar(ConsultaRequest c) throws Exception;

	Consulta modificar(Consulta c) throws Exception;
	Consulta modificar(int id, ConsultaRequest c) throws Exception;
	
	Consulta buscar(int id) throws Exception;
	
	List<Consulta> listarTodos() throws Exception;

	List<Consulta> listarPorFecha(String fecha) throws Exception;

	List<Consulta> listarPorMedico(String id) throws Exception;

	List<Consulta> listarPorPaciente(String id) throws Exception;
}
