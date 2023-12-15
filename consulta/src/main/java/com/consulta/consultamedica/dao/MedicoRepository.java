package com.consulta.consultamedica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulta.consultamedica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
