package com.bootcamp.databases.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Medico findByDni(String dni);
}
