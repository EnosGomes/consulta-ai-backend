package com.creta.consultaai.dto;

import java.time.LocalDate;
import java.util.List;


import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.model.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Data
public class PacienteDTO {

	private Integer id;
	private long codigoPaciente;
	private String numeroSus;
	private String numeroCelular;
	private List<Consulta> consultas;

	//Herdadas de Usuario
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	
	@NotNull(message = "Data de Nascimento é obrigatória")
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public PacienteDTO() {
	}

}
