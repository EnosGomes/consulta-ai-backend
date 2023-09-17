package com.creta.consultaai.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Paciente  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private long codigoPaciente;
	@NotBlank(message = "Numero SUS é obrigatório.")
	private String numeroSus;
	private String numeroCelular;
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Consulta> consultas = new ArrayList<>();

	private String cpf;
	private String email;
	private String senha;
	private String nome;
	public Paciente() {
		super();
	}

	public Paciente(long codigoPaciente, String numeroSus) {
		super();
		this.codigoPaciente = codigoPaciente;
		this.numeroSus = numeroSus;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", codigoPaciente=" + codigoPaciente + ", numeroSus=" + numeroSus
				+ ", numeroCelular=" + numeroCelular + ", consultas=" + consultas + "]";
	}
}
