package com.creta.consultaai.domain;

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
