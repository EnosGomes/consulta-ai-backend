package com.creta.consultaai.exception;

import org.springframework.http.HttpStatus;

public class MedicoNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;

	public MedicoNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}
	
}
