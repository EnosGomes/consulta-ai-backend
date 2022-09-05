package com.creta.consultaai.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank(message = "Nome da consulta é obrigatório.")
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	private LocalDate dataConsulta;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFim;
	private String observacoes;
	private boolean isCancelada;
	private boolean isAgendada;
	private LocalDate novaDataConsulta; // pensar no historicos de varias agendamentos e cancelamentos de consultas

	public Consulta() {
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
