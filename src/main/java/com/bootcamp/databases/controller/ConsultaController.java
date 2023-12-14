package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.ConsultaRequest;
import com.bootcamp.databases.model.documents.DetalleConsulta;
import com.bootcamp.databases.model.entity.Consulta;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleConsultaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
@Slf4j
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private DetalleConsultaService detalleConsultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> listar() throws Exception {
        return ResponseEntity.ok(consultaService.listarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Consulta> listar(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(consultaService.buscar(id));
    }

    @GetMapping("/paciente/{dni}")
    public ResponseEntity<List<Consulta>> listarPorPaciente(@PathVariable String dni) throws Exception {
        return ResponseEntity.ok(consultaService.listarPorPaciente(dni));
    }

    @GetMapping("/medico/{dni}")
    public ResponseEntity<List<Consulta>> listarPorMedico(@PathVariable String dni) throws Exception {
        return ResponseEntity.ok(consultaService.listarPorMedico(dni));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Consulta>> listarPorFecha(@PathVariable String fecha) throws Exception {
        return ResponseEntity.ok(consultaService.listarPorFecha(fecha));
    }

    @GetMapping("/detalle")
    public ResponseEntity<List<DetalleConsulta>> listarDetalle() throws Exception {
        return ResponseEntity.ok(detalleConsultaService.listarTodos());
    }

    @PostMapping("/detalle")
    public ResponseEntity<DetalleConsulta> crearDetalle(@RequestBody DetalleConsulta d) throws Exception {
        return ResponseEntity.ok(detalleConsultaService.registrar(d));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ConsultaRequest c) throws Exception {
        try {
            return ResponseEntity.ok(consultaService.registrar(c));
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error al crear la consulta, Detalle del error: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Consulta> crear(@RequestBody Consulta c) throws Exception {
        return ResponseEntity.ok(consultaService.registrar(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable int id, @RequestBody ConsultaRequest c) throws Exception {
        log.info("id: " + id);
        try {
            return ResponseEntity.ok(consultaService.modificar(id, c));
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return ResponseEntity.badRequest().body("Error al editar la consulta, Detalle del error: " + e.getMessage());
        }
    }
}
