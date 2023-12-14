package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.entity.Especialidad;
import com.bootcamp.databases.service.EspecialidadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
@Slf4j
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> listar() throws Exception {
        return ResponseEntity.ok(especialidadService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> buscar(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(especialidadService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Especialidad> crear(Especialidad e) throws Exception {
        try {
            especialidadService.registrar(e);
            return ResponseEntity.ok(e);
        } catch (Exception ex) {
            log.error("No se pudo registrar la especialidad");
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping
    public ResponseEntity<Especialidad> modificar(Especialidad e) throws Exception {
        especialidadService.modificar(e);
        return ResponseEntity.ok(e);
    }
}
