package com.creta.consultaai.exception;

import org.springframework.http.HttpStatus;

public class AlertaNotFoundException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public AlertaNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}
	
}
