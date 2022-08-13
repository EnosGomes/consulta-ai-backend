package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Consulta;
import com.creta.consultaai.service.ConsultaService;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {

	@Autowired
	ConsultaService consultaService;

	@GetMapping(value = "/todos")
	public List<Consulta> getAllConsultas() {

		return consultaService.retornaTodasConsultas();
	}
}
