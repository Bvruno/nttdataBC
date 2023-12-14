package com.bootcamp.databases.model.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsulta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaPaciente"))
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "idMedico", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaMedico"))
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "idEspecialidad", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaEspecialidad"))
	private Especialidad especialidad;

}
