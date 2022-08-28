package com.creta.consultaai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.dto.PacienteDTO;
import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> retornaTodosPacientes() {

		List<Paciente> todosPacientes = pacienteRepository.findAll();
		
		//aqui usar o modelmapper
		List<PacienteDTO> pacientesDto = todosPacientes
				.stream()
				.map(obj -> new PacienteDTO(obj))
				.collect(Collectors.toList());
		

		if (todosPacientes.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há pacientes cadastrados");
		} 
		
		return todosPacientes;
	}
	
	public Paciente retornaPacientePorId(Long id){
		
		Optional<Paciente> todosPaciente = pacienteRepository.findById(id);
		
		if(todosPaciente.isPresent()) {
			return todosPaciente.get();
		}
		
		throw new RuntimeException("Não foi encontrado nenhum paciente com id = "+id);
		
	}
	
	public Paciente inserePaciente(Paciente paciente) {
		
		if(paciente == null) {
			throw new RuntimeException("Paciente com erro ai mano!");
		}
		
		return pacienteRepository.save(paciente);
	}

}
