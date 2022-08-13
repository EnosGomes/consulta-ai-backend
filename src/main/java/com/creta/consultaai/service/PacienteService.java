package com.creta.consultaai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.domain.Paciente;
import com.creta.consultaai.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> retornaTodosPacientes() {

		List<Paciente> todosPacientes = pacienteRepository.findAll();

		if (todosPacientes.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há pacientes cadastrados");
		} 
		
		return todosPacientes;
	}
	
	public Paciente retornaBuscaPorIdPacientes(Long id){
		
		Optional<Paciente> todosPaciente = pacienteRepository.findById(id);
		
		if(todosPaciente.isPresent()) {
			return todosPaciente.get();
		}
		
		throw new RuntimeException("Não foi encontrado nenhum paciente com esse id.");
		
	}

}
