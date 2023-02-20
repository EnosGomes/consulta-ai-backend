package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Medico;

public interface MedicoService {
	
	public List<Medico> retornaTodosMedicos();
	public Medico retornaMedicoPorId(Integer id);
	public Medico insereMedico(Medico medico);
	public Medico alteraMedico(Medico medico, Integer id);
	public void deletaMedico(Integer id);

}
