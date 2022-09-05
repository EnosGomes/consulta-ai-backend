package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Consulta;

public interface ConsultaService {
	
	public List<Consulta> retornaTodasConsultas();
	public Consulta cadastraConsulta(Consulta consulta);

}
