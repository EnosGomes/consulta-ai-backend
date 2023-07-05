package com.creta.consultaai.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	// Gerar automatico com o nomeP ex: p1 ou p54
	private long codigoPaciente;

	@NotBlank(message = "Numero SUS é obrigatório.")
	private String numeroSus;

	private String numeroCelular;

	// Doenca

	@JsonIgnore
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<Consulta> consultas = new ArrayList<>();

	public Paciente() {
		super();
	}

	public Paciente(long codigoPaciente, String numeroSus) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.numeroSus = numeroSus;
	}

	public Integer getId() {
		return id;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", codigoPaciente=" + codigoPaciente + ", numeroSus=" + numeroSus
				+ ", numeroCelular=" + numeroCelular + ", consultas=" + consultas + "]";
	}

}