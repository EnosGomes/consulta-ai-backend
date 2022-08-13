package com.creta.consultaai.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Hospital() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
