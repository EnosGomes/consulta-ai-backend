package com.creta.consultaai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank(message = "Nome da consulta é obrigatório.")
	private String nome;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	//Falar colocar o hospital

	private Boolean medicoAceitouConsulta;

	private StatusConsulta statusConsulta; // enum com agendada, cancelada, esperando agendamento, concluida

	private LocalDate dataConsulta;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFim;
	private String observacoes;
	private boolean isCancelada;
	private boolean isAgendada; //so pode ser agendada, terminada ou cancelada
	private LocalDate novaDataConsulta; // pensar no historicos de varias agendamentos e cancelamentos de consultas

	public Consulta() {
	}

	public Consulta(String nome) {
		this.nome = nome;
	}

	public Consulta(String nome, Medico medico, Paciente paciente, Boolean medicoAceitouConsulta) {
		this.nome = nome;
		this.medico = medico;
		this.paciente = paciente;
		this.statusConsulta = StatusConsulta.PROCESSANDO;
		this.medicoAceitouConsulta = medicoAceitouConsulta;
	}

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public boolean isMedicoAceitouConsulta() {
		return medicoAceitouConsulta;
	}

	public void setMedicoAceitouConsulta(Boolean medicoAceitouConsulta) {
		this.medicoAceitouConsulta = medicoAceitouConsulta;
	}

	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(nome, other.nome);
	}



}
