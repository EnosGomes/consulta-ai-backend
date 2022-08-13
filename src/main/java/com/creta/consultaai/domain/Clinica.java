package com.creta.consultaai.domain;

public class Clinica {
	
	private long id;
	private String nome;

	public Clinica() {
		super();
	}

	public Clinica(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

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

}
