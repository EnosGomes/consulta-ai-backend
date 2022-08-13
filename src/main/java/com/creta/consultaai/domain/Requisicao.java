package com.creta.consultaai.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Requisicao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//private Consulta consulta;
	private String statusRequisicao; //vai virar um enum ou algo do tipo
	private boolean isAtiva;
	private boolean isCancelada;
	
	//@Column(nullable = false) ou NotBlank ?
	
	
	/*
	@CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; 
    
    * @UpdateTimestamp
    @Column(name = "updated_at")
    private  LocalDateTime updatedAt;
    */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
