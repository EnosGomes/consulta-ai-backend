package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Requisicao;

public interface RequisicaoService {
	
	List<Requisicao> retornaTodosRequisicoes();
	Requisicao retornaRequisicaoPorId(Long id);

}
