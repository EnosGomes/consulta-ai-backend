package com.creta.consultaai.model;

public enum StatusConsulta {
	AGENDADA("masculino"),
	CANCELADA("feminino"),
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
