package com.creta.consultaai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> retornaTodosHospitais() {

		List<Hospital> todosHospitais = hospitalRepository.findAll();

		if (todosHospitais.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há hospitais cadastrados"); //criar suas proprias exceptions
		} 
		
		return todosHospitais;
	}
	
	public Hospital insereHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

}
