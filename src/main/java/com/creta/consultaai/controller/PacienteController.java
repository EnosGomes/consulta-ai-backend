package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.dto.PacienteDTO;
import com.creta.consultaai.mapper.PacienteMapper;
import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.service.impl.PacienteServiceImpl;

@RestController
@RequestMapping(value = "${urlpadrao}/pacientes")
public class PacienteController {

	private PacienteMapper pacienteMapper;

	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	PacienteServiceImpl pacienteService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Paciente>> getAllPacientes() {
		
		//retorna uma lista de PacienteDTO
		return ResponseEntity.ok(pacienteService.retornaTodosPacientes());
	}

	@GetMapping(value = "/nome")
	public ResponseEntity<Paciente> getPacienteById(@RequestParam("nome") String nome) {

		return ResponseEntity.ok(pacienteService.buscaPacientePeloNome(nome));
	}

	@PostMapping
	public ResponseEntity<PacienteDTO> cadastraPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
		
		Paciente paciente = PacienteMapper.toPaciente(pacienteDTO);

		pacienteService.inserePaciente(paciente);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pacienteDTO.getId()).toUri();
		logger.info("Paciente inserido com sucesso!");

		return ResponseEntity.created(location).build(); // rest concepts
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Paciente> alteraPaciente(@Valid @RequestBody Paciente paciente, @PathVariable Integer id) {

		pacienteService.alteraPaciente(paciente, id);
		logger.info("Paciente alterado com sucesso!");

		return ResponseEntity.noContent().build(); // rest concepts
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletaPaciente(@PathVariable Integer id) {

		pacienteService.deletaPaciente(id);
		logger.info("Paciente excluído com sucesso!");

		return ResponseEntity.noContent().build();
	}

}
