package com.creta.consultaai.model;

public enum StatusConsulta {
	AGENDADA("agendada"),
	CANCELADA("cancelada"),
	CONCLUIDA("concluida"),
	PROCESSANDO("processando")
	;

	private final String statusConsulta;

	private StatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}
}
