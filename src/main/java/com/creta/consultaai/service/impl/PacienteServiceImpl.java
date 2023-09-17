package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;

import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.PacienteNotFoundException;
import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.repository.PacienteRepository;
import com.creta.consultaai.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	public List<Paciente> retornaTodosPacientes() {
		List<Paciente> todosPacientes = pacienteRepository.findAll();
		if (todosPacientes.isEmpty()) {
			throw new PacienteNotFoundException("Não há pacientes cadastrados");
		}
		return todosPacientes;
	}

	public Paciente inserePaciente(Paciente paciente) {

		if (paciente == null) {
			throw new PacienteNotFoundException("Erro na inserção do Paciente!");
		}

		return pacienteRepository.save(paciente);
	}

	@Override
	public void deletaPaciente(Integer id) {
		Optional<Paciente> buscaPaciente = pacienteRepository.findById(id);

		if (buscaPaciente.isPresent()) {
			pacienteRepository.delete(buscaPaciente.get());
		} else {
			throw new PacienteNotFoundException("Erro ao deletar o Paciente");
		}
	}

	public Paciente retornaPacientePorId(Integer id){
		return pacienteRepository.findById(id).get();
	}
}
