package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Consulta;
import com.creta.consultaai.service.ConsultaService;

@RestController
@RequestMapping(value = "${url.padrao}/consultas")
public class ConsultaController {

	@Autowired
	ConsultaService consultaService;

	@GetMapping(value = "/todos")
	public List<Consulta> getAllConsultas() {
		
		//if situacao de erro , retorna bad reques
		// return caso feliz que ai não fica com o else do if e não fica feio

		return consultaService.retornaTodasConsultas();
	}
}
