package com.bootcamp.databases.repository.jpa;

import com.bootcamp.databases.model.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findAllByPacienteDni(String dni);
    List<Consulta> findAllByMedicoDni(String dni);
    List<Consulta> findAllByFechaBetween(Date fechaInicio, Date fechaFin);
}
