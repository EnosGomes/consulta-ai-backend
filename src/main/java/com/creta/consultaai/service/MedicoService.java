package com.creta.consultaai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.model.Medico;
import com.creta.consultaai.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> retornaTodosMedicos() {

		List<Medico> todosMedicos = medicoRepository.findAll();

		if (todosMedicos.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há médicos cadastrados");
		} 
		
		return todosMedicos;
	}
	
	public Medico retornaMedicoPorId(Long id){
		
		Optional<Medico> todosMedicos = medicoRepository.findById(id);
		
		if(todosMedicos.isPresent()) {
			return todosMedicos.get();
		}
		
		throw new RuntimeException("Não foi encontrado nenhum médico com esse id.");
		
	}

}
