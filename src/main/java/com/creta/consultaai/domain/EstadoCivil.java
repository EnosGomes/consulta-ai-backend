package com.creta.consultaai.domain;

public enum EstadoCivil {
    SOLTEIRO("solteiro"),
    CASADO("casado"),
    DIVORCIADO("divorciado"),
    VIUVO("viuvo");
	
	private final String status;

	private EstadoCivil(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
