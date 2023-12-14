package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.entity.Paciente;
import com.bootcamp.databases.service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Slf4j
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() throws Exception {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(pacienteService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> crear(Paciente p) throws Exception {
        try {
            pacienteService.registrar(p);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            log.error("No se pudo registrar el paciente");
            return ResponseEntity.badRequest().body(p);
        }
    }

    @PutMapping
    public ResponseEntity<Paciente> modificar(Paciente p) throws Exception {
        pacienteService.modificar(p);
        return ResponseEntity.ok(p);
    }
}
