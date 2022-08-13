package com.creta.consultaai.domain;

public class Requisicao {
	private long id;
	private Consulta consulta;
	private String statusRequisicao; //vai virar um enum ou algo do tipo
	private boolean isAtiva;
	private boolean isCancelada;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getStatusRequisicao() {
		return statusRequisicao;
	}
	public void setStatusRequisicao(String statusRequisicao) {
		this.statusRequisicao = statusRequisicao;
	}
	public boolean isAtiva() {
		return isAtiva;
	}
	public void setAtiva(boolean isAtiva) {
		this.isAtiva = isAtiva;
	}
	public boolean isCancelada() {
		return isCancelada;
	}
	public void setCancelada(boolean isCancelada) {
		this.isCancelada = isCancelada;
	}
	
	
	
}
