package com.bootcamp.databases.model.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consultaExamen")
@Builder
@Data
public class ConsultaExamen {
    private String idExamen;
    private String idConsulta;
}
