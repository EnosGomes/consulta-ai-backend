package com.creta.consultaai.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;
    
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
    
	private LocalDate dataConsulta;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private String observacoes;
    private boolean isCancelada;
    private boolean isAgendada;
    private LocalDate novaDataConsulta; //pensar no historicos de varias agendamentos e cancelamentos de consultas
    
    public Consulta() {}
	
	
	public LocalDate getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDateTime getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(LocalDateTime horaFim) {
		this.horaFim = horaFim;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public boolean isCancelada() {
		return isCancelada;
	}
	public void setCancelada(boolean isCancelada) {
		this.isCancelada = isCancelada;
	}
	public boolean isAgendada() {
		return isAgendada;
	}
	public void setAgendada(boolean isAgendada) {
		this.isAgendada = isAgendada;
	}
	public LocalDate getNovaDataConsulta() {
		return novaDataConsulta;
	}
	public void setNovaDataConsulta(LocalDate novaDataConsulta) {
		this.novaDataConsulta = novaDataConsulta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	

}
