package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "${url.padrao}/pacientes")
@Slf4j
public class PacienteController {

	@Autowired
	PacienteService pacienteService;

	@GetMapping(value = "/todos")
	public ResponseEntity<List<Paciente>> getAllPacientes() {

		return ResponseEntity.ok(pacienteService.retornaTodosPacientes());
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
		
		return ResponseEntity.ok(pacienteService.retornaPacientePorId(id));
	}

}
