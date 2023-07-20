package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Paciente;

public interface PacienteService {
	
	public List<Paciente> retornaTodosPacientes();
	public Paciente inserePaciente(Paciente paciente);	
	public Paciente alteraPaciente(Paciente paciente, Integer id);
	public void deletaPaciente(Integer id);

}
