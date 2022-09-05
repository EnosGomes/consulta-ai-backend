package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.service.impl.PacienteServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "${urlpadrao}/pacientes")
@Slf4j
public class PacienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	PacienteServiceImpl pacienteService;

	@GetMapping(value = "/todos")
	public ResponseEntity<List<Paciente>> getAllPacientes() {

		return ResponseEntity.ok(pacienteService.retornaTodosPacientes());
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
		
		return ResponseEntity.ok(pacienteService.retornaPacientePorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Paciente> cadastraPaciente(@Valid @RequestBody Paciente paciente){
		
		pacienteService.inserePaciente(paciente);		
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(paciente.getId())
                                    .toUri();
        logger.info("Paciente inserido com sucesso!");
        
        return ResponseEntity.created(location).build(); //rest concepts
	}

}
