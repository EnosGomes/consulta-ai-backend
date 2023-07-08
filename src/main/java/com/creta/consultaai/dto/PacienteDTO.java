package com.creta.consultaai.dto;

import java.time.LocalDate;
import java.util.List;


import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.model.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class PacienteDTO {

	private Integer id;
	private long codigoPaciente;
	private String numeroSus;
	private String numeroCelular;
	private List<Consulta> consultas;
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	
	@NotNull(message = "Data de Nascimento é obrigatória")
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public PacienteDTO() {
	}

	public PacienteDTO(Paciente paciente) {
		this.codigoPaciente = paciente.getCodigoPaciente();
		this.numeroCelular = paciente.getNumeroCelular();
	}	
	
	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
