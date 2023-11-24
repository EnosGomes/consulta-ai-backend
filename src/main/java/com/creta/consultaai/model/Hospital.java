package com.creta.consultaai.model;


import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank(message = "Nome do Hospital é obrigatório")
	private String nome;

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	private String cnes;

	private Boolean ativo;

	//private Especialidades especialidades;

	public Hospital() {
	}

	public Hospital(@NotBlank String nome, @NotBlank String codigo) {
		super();
		this.nome = nome;
		this.ativo = true;
		this.cnes =codigo;
	}	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCodigo() {
		return cnes;
	}

	public void setCodigo(String codigo) {
		this.cnes = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnes, nome);
	}

	private String gerarCodigoHospital(){
		return "hosp"+this.id.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		return Objects.equals(cnes, other.cnes) && Objects.equals(nome, other.nome);
	}	

}
