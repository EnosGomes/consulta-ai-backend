package com.creta.consultaai.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class UnidadeSaude {

	private UUID id;
	private String nome;
	private String codigo;
	private Endereco endereco;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public UnidadeSaude() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeSaude other = (UnidadeSaude) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}

}
