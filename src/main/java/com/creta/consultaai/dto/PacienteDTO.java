package com.creta.consultaai.dto;

import java.util.ArrayList;
import java.util.List;

import com.creta.consultaai.domain.Consulta;
import com.creta.consultaai.domain.Paciente;

public class PacienteDTO {	

	private Long id;
	
	private long codigoPaciente;
	private String numeroSus;	
	private String numeroCelular;
	private List<Consulta> consultas = new ArrayList<>();
	
	public PacienteDTO () {}
	
	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.codigoPaciente = paciente.getCodigoPaciente();
		this.numeroCelular = paciente.getNumeroCelular();
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(long codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public String getNumeroSus() {
		return numeroSus;
	}
	public void setNumeroSus(String numeroSus) {
		this.numeroSus = numeroSus;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	

}
