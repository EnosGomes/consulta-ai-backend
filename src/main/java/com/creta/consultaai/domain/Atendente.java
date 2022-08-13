package com.creta.consultaai.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atendente extends Usuario{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Atendente() {}	
	
}
