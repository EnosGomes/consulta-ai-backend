package com.creta.consultaai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medico extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private Set<Consulta> consultas;

	@NotBlank(message = "CRM é obrigatório.")
	@Column(unique = true)
	private String crm; // precisa de mascara e validation

	@NotBlank(message = "Especialidade é obrigatória.")
	private String especialidade;

	//@OneToMany
	//List<Hospital> hospitais; // um medico trabalha em vários hospitais


	public Medico() {
	}

	public Medico(@NotBlank(message = "CRM é obrigatório.") String crm) {
		super();
		this.crm = crm;
	}

	public Integer getId() {
		return id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Set<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
