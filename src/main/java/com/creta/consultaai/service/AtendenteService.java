package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Atendente;

public interface AtendenteService {

	public List<Atendente> retornaTodosAtendentes();
	public Atendente retornaAtendentePorId(Long id);
	
	
}
