package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.model.Requisicao;
import com.creta.consultaai.service.RequisicaoService;


@RestController
@RequestMapping(value = "${urlpadrao}/requisicoes")
public class RequisicaoController {

	@Autowired
	RequisicaoService requisicaoService;

	@GetMapping(value = "/todos")
	public List<Requisicao> getAllPacientes() {

		return requisicaoService.retornaTodosRequisicoes();
	}

}
