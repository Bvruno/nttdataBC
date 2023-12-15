package com.consulta.consultamedica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
/*
	@Getter
	@Setter
	@ToString
	@EqualsAndHashCode
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "tbl_Medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;
	@Column(name = "especialidad", nullable = false, length = 70)
	private String especialidad;
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;	
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

}
