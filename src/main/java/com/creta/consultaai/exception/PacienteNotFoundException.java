package com.creta.consultaai.exception;

import org.springframework.http.HttpStatus;

public class PacienteNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;

	public PacienteNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}
	
}
