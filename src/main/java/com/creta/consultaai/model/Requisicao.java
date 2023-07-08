package com.creta.consultaai.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Requisicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	// private Consulta consulta;

	private String statusRequisicao; // vai virar um enum ou algo do tipo
	private boolean isAtiva;
	private boolean isCancelada;

	public Requisicao() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
