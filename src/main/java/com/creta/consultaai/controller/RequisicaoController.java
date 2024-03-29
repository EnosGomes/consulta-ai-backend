package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.model.Requisicao;
import com.creta.consultaai.service.impl.RequisicaoServiceImpl;


@RestController
@RequestMapping(value = "${urlpadrao}/requisicoes")
public class RequisicaoController {

	@Autowired
	RequisicaoServiceImpl requisicaoService;

	@GetMapping(value = "/todos")
	public List<Requisicao> getAllRequisicoes() {

		return requisicaoService.retornaTodosRequisicoes();
	}

}
