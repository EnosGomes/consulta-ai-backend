package com.creta.consultaai.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medico extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private Set<Consulta> consultas;

	@NotBlank(message = "CRM é obrigatório.")
	@Column(unique = true)
	private String crm; // precisa de mascara e validation

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

}
