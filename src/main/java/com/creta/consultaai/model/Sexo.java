package com.creta.consultaai.model;

public enum Sexo {
    MASCULINO("masculino"),
    FEMININO("feminino");
	
	private final String sexo;

	private Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getStatus() {
		return sexo;
	}
}
