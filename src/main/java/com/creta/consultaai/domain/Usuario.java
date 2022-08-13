package com.creta.consultaai.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public abstract class  Usuario {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório.")
    private String nome;
	
	@CPF(message = "CPF é obrigatório.")
	@Column(unique = true)
    private String cpf;
    
    @NotNull(message = "Data de Nascimento é obrigatória")
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    @Column(unique=true)
    @NotBlank(message = "Email é obrigatório.")
    @Email
    private String email;
    
    @JsonIgnore
    @NotBlank(message = "Senha é obrigatória")
    private String senha;
    
    //@ElementCollection
	//@CollectionTable(name="TELEFONE")
    //private Set<String> telefones;
    
    //@ElementCollection(fetch=FetchType.EAGER)
	//@CollectionTable(name="PERFIS")
	//private Set<Integer> perfis = new HashSet<>();
	
	public Usuario () {}
	
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
	public long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}      

}
