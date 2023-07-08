package com.creta.consultaai.dto;

import java.time.LocalDate;


import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class MedicoDTO {
	
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "CRM é obrigatório.")
	private String crm;

	@CPF(message = "CPF é obrigatório.")
	private String cpf;

	@NotNull(message = "Data de Nascimento é obrigatória")
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotBlank(message = "Email é obrigatório.")
	@Email
	private String email;

	@NotBlank(message = "Senha é obrigatória")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}	

}
