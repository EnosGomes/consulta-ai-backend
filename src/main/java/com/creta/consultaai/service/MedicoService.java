package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Medico;

public interface MedicoService {
	
	public List<Medico> retornaTodosMedicos();
	public Medico retornaMedicoPorId(Long id);

}
