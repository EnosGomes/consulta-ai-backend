package com.creta.consultaai.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medico extends Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;  
	
	@JsonIgnore
	@OneToMany(mappedBy="medico")
	private Set<Consulta> consultas;
	
	@NotBlank(message = "CRM é obrigatório.")
	@Column(unique = true)
    private String crm; //precisa de mascara e validation
    
    public Medico() {}

	public Medico(@NotBlank(message = "CRM é obrigatório.") String crm) {
		super();
		this.crm = crm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
