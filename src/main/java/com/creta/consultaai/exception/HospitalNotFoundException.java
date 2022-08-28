package com.creta.consultaai.exception;

import org.springframework.http.HttpStatus;

public class HospitalNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = 1L;

	public HospitalNotFoundException(String msg) {
		super(msg, HttpStatus.NOT_FOUND);
	}
	
}
