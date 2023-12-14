package com.bootcamp.databases.repository.jpa;

import com.bootcamp.databases.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByDni(String dni);
}
