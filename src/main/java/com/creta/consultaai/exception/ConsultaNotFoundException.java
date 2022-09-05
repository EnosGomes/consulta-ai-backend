package com.creta.consultaai.exception;

import org.springframework.http.HttpStatus;

public class ConsultaNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;

	public ConsultaNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}
	
}
