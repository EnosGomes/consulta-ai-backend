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
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Consulta{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Nome da consulta é obrigatório.")
	private String nome;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
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

	public void adicionaPacienteNaConsulta(Paciente paciente){
		this.paciente = paciente;
	}

}
