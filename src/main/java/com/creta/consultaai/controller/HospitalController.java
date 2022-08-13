package com.creta.consultaai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Hospital;
import com.creta.consultaai.service.HospitalService;

@RestController
@RequestMapping(value = "/hospitais")
public class HospitalController {

	@Autowired
	HospitalService hospitalService;

	@GetMapping(value = "/todos")
	public List<Hospital> getAllPacientes() {

		return hospitalService.retornaTodosHospitais();
		
		
		/*
		 * if (hospitalService.isPresent()){
		 * 	
		 * 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 * 
		 * }
		 * 
		 * return  return new ResponseEntity<Hospital>(hospitalService.get(), HttpStatus.OK);
		 * 
		 * */
	}

}
