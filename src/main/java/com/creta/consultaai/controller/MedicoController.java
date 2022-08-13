package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Medico;
import com.creta.consultaai.service.MedicoService;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

	@Autowired
	MedicoService medicoService;

	@GetMapping(value = "/todos")
	public List<Medico> getAllPacientes() {

		return medicoService.retornaTodosMedicos();
	}

	@GetMapping(value = "/id/{id}")
	public Medico getPacienteById(@PathVariable Long id) {

		return medicoService.retornaMedicoPorId(id);

	}

}
