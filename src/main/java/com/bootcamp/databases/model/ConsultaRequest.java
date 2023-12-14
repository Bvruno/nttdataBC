package com.bootcamp.databases.model;

import lombok.Data;

@Data
public class ConsultaRequest {
    private String dniPaciente;
    private String dniMedico;
    private String especialidad;
}
