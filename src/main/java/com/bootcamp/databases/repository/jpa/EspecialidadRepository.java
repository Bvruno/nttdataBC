package com.bootcamp.databases.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.entity.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

    Especialidad findByNombre(String especialidad);
}
