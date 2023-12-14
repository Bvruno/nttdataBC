package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.ConsultaRequest;
import com.bootcamp.databases.model.entity.Consulta;
import com.bootcamp.databases.repository.jpa.ConsultaRepository;
import com.bootcamp.databases.repository.jpa.EspecialidadRepository;
import com.bootcamp.databases.repository.jpa.MedicoRepository;
import com.bootcamp.databases.repository.jpa.PacienteRepository;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.util.ConsultaNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository repo;
	@Autowired
	private MedicoRepository medicoRepo;
	@Autowired
	private PacienteRepository pacienteRepo;
	@Autowired
	private EspecialidadRepository especialidadRepo;

	@Override
	public Consulta registrar(Consulta m) throws Exception {
		return repo.save(m);
	}

	@Override
	public Consulta registrar(ConsultaRequest c) throws Exception {
		Consulta consulta = new Consulta();
		consulta.setEspecialidad(especialidadRepo.findByNombre(c.getEspecialidad()));
		consulta.setFecha(new Date());
		consulta.setMedico(medicoRepo.findByDni(c.getDniMedico()));
		consulta.setPaciente(pacienteRepo.findByDni(c.getDniPaciente()));
		return repo.save(consulta);
	}

	@Override
	public Consulta modificar(Consulta m) throws Exception {
		return repo.save(m);

	}

	@Override
	public Consulta modificar(int idConsulta, ConsultaRequest c) throws Exception {
		log.info(String.valueOf(repo.findById(idConsulta).get()));
		return repo.findById(idConsulta)
				.map(consulta -> {
					consulta.setFecha(new Date());
					consulta.setMedico(medicoRepo.findByDni(c.getDniMedico()));
					consulta.setEspecialidad(especialidadRepo.findByNombre(c.getEspecialidad()));
					return repo.save(consulta);
				})
				.orElseThrow();
	}

	@Override
	public Consulta buscar(int id) throws Exception {
		Optional<Consulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Consulta();
	}

	@Override
	public List<Consulta> listarTodos() throws Exception {
		return repo.findAll();
	}

	@Override
	public List<Consulta> listarPorFecha(String fecha) throws Exception {
		return repo.findAllByFechaBetween(convertirStringADate(fecha), new Date());
	}

	private static Date convertirStringADate(String fechaString) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return formatoFecha.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Consulta> listarPorMedico(String dni) throws Exception {
		return repo.findAllByMedicoDni(dni);
	}

	@Override
	public List<Consulta> listarPorPaciente(String dni) throws Exception {
		return repo.findAllByPacienteDni(dni);
	}

}
