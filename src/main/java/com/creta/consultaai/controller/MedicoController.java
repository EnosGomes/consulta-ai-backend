package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.dto.MedicoDTO;
import com.creta.consultaai.mapper.MedicoMapper;
import com.creta.consultaai.model.Medico;
import com.creta.consultaai.service.impl.MedicoServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "${urlpadrao}/medicos")
public class MedicoController {

	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	MedicoServiceImpl medicoService;
	
	
	private MedicoMapper medicoMapper;

	@GetMapping
	public List<Medico> getAllPacientes() {

		return medicoService.retornaTodosMedicos();
	}

	@GetMapping(value = "/id/{id}")
	public Medico getPacienteById(@PathVariable Integer id) {

		return medicoService.retornaMedicoPorId(id);

	}

	@PostMapping
	public ResponseEntity<Medico> cadastraMedico(@Valid @RequestBody Medico medicoDTO) {

		medicoService.insereMedico(medicoDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand()
				.toUri();
		logger.info("Médico inserido com sucesso!");

		return ResponseEntity.created(location).build(); // rest concepts
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Medico> alteraPaciente(@Valid @RequestBody Medico medico, @PathVariable Integer id) {

		medicoService.alteraMedico(medico, id);
		logger.info("Paciente alterado com sucesso!");

		return ResponseEntity.noContent().build(); // rest concepts
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletaPaciente(@PathVariable Integer id) {

		medicoService.deletaMedico(id);
		logger.info("Paciente excluído com sucesso!");

		return ResponseEntity.noContent().build();
	}

}
