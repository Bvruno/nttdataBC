package com.consulta.consultamedica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.consultamedica.model.Medico;
import com.consulta.consultamedica.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) {
		service.registrar(m);
		return ResponseEntity.ok(m);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Medico> buscar(@RequestParam("id") int id) {
		return ResponseEntity.ok(service.buscar(id));
	}
}
