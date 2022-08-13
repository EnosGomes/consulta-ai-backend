package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Paciente;
import com.creta.consultaai.service.PacienteService;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;

	@GetMapping(value = "/todos")
	public List<Paciente> getAllPacientes() {

		return pacienteService.retornaTodosPacientes();
	}

	@GetMapping(value = "/id/{id}")
	public Paciente getPacienteById(@PathVariable Long id) {

		return pacienteService.retornaBuscaPorIdPacientes(id);

	}

}
