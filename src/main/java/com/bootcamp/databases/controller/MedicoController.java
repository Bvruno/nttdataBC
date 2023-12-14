package com.bootcamp.databases.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.databases.model.entity.Medico;
import com.bootcamp.databases.service.MedicoService;

@RestController
@RequestMapping("/medicos")
@Slf4j
public class MedicoController {

	@Autowired
	private MedicoService service;

	@GetMapping()
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

	@PostMapping()
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) {
		log.info("Registrar nuevo médico");
		try {
			service.registrar(m);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			log.error("No se pudo registrar el médico");
			return ResponseEntity.badRequest().body(m);
		}
	}

	@PutMapping()
	public ResponseEntity<Medico> actualizar(@RequestBody Medico m) throws Exception {
		service.registrar(m);
		return ResponseEntity.ok(m);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> buscar(@PathVariable int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}

}
