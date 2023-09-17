package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.creta.consultaai.exception.PacienteNotFoundException;
import org.modelmapper.ModelMapper;
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

import com.creta.consultaai.dto.PacienteDTO;
import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.service.impl.PacienteServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "${urlpadrao}/pacientes")
public class PacienteController {
	@Autowired
	private ModelMapper modelMapper;

	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	PacienteServiceImpl pacienteService;



	@GetMapping(value = "/todos")
	public ResponseEntity<List<PacienteDTO>> getAllPacientes() {

		return ResponseEntity.ok(
				pacienteService.retornaTodosPacientes()
						.stream()
						.map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
						.collect(Collectors.toList())

		);
		
		//retorna uma lista de PacienteDTO
//		return ResponseEntity.ok(pacienteService.retornaTodosPacientes());
	}

	@PostMapping
	public ResponseEntity<PacienteDTO> cadastraPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {

		Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
		pacienteService.inserePaciente(paciente);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pacienteDTO.getId()).toUri();
		logger.info("Paciente inserido com sucesso!");

		return ResponseEntity.created(location).build(); // rest concepts
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletaPaciente(@PathVariable Integer id) {

		pacienteService.deletaPaciente(id);
		logger.info("Paciente excluído com sucesso!");

		return ResponseEntity.noContent().build();
	}

}
