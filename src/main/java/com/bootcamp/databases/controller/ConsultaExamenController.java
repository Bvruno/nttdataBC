package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.documents.ConsultaExamen;
import com.bootcamp.databases.model.documents.Examen;
import com.bootcamp.databases.service.ConsultaExamenService;
import com.bootcamp.databases.service.DetalleConsultaService;
import com.bootcamp.databases.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultaExamen")
public class ConsultaExamenController {

    @Autowired
    private ConsultaExamenService consultaExamenService;
    @Autowired
    private ExamenService examenService;

    @GetMapping("/examen")
    public ResponseEntity<List<Examen>> listarPorExamen() throws Exception {
        return ResponseEntity.ok(examenService.listarTodos());
    }

    @PostMapping("/examen")
    public ResponseEntity<Examen> crearExamen(@RequestBody Examen e) throws Exception {
        return ResponseEntity.ok(examenService.registrar(e));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaExamen>> listar() throws Exception {
        return ResponseEntity.ok(consultaExamenService.listarTodos());
    }

    @GetMapping("/porPaciente/{idPaciente}")
    public ResponseEntity<List<ConsultaExamen>> listarPorPaciente(@PathVariable String idPaciente) throws Exception {
        return ResponseEntity.ok(consultaExamenService.listarPorPaciente(idPaciente));
    }

    @GetMapping("/porMedico/{idMedico}")
    public ResponseEntity<List<ConsultaExamen>> listarPorMedico(@PathVariable String idMedico) throws Exception {
        return ResponseEntity.ok(consultaExamenService.listarPorMedico(idMedico));
    }

    @GetMapping("/porConsulta/{idConsulta}")
    public ResponseEntity<List<ConsultaExamen>> listarPorConsulta(@PathVariable String idConsulta) throws Exception {
        return ResponseEntity.ok(consultaExamenService.listarPorConsulta(idConsulta));
    }

    @PostMapping
    public ResponseEntity<ConsultaExamen> crear(@RequestBody ConsultaExamen ce) throws Exception {
        return ResponseEntity.ok(consultaExamenService.registrar(ce));
    }
}
