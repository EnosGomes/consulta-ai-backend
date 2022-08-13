package com.creta.consultaai.domain;

public abstract class UnidadeSaude { //no futuro vai ser a mãe de Hospital, Clinica, Etc
	
	private long id;
	private String nome;
	private String codigo;
	private Endereco endereco;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public UnidadeSaude() {}

}
