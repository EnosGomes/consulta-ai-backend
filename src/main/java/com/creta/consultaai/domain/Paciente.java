package com.creta.consultaai.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long codigoPaciente;
	
	@NotBlank(message = "Numero SUS é obrigatório.")
	private String numeroSus;
	private String numeroCelular;
	
	@JsonIgnore
	@OneToMany(mappedBy="paciente")
	private List<Consulta> consultas = new ArrayList<>();

	// @Transient
	// private Endereco endereco; //por enquanto somente um

	public Paciente() {
		super();
	}

	public Paciente(Long id, long codigoPaciente, String numeroSus, String numeroCelular) {
		super();
		this.id = id;
		this.codigoPaciente = codigoPaciente;
		this.numeroSus = numeroSus;
		this.numeroCelular = numeroCelular;
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

}
