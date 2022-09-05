package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Paciente;

public interface PacienteService {
	
	public List<Paciente> retornaTodosPacientes();
	public Paciente retornaPacientePorId(Long id);
	public Paciente inserePaciente(Paciente paciente);	

}
