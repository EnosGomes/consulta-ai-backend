package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Requisicao;

public interface RequisicaoService {
	
	public List<Requisicao> retornaTodosRequisicoes();
	public Requisicao retornaRequisicaoPorId(Long id);

}
