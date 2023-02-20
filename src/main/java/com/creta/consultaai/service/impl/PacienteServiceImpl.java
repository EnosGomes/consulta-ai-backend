package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;

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

	public List<Paciente> retornaTodosPacientes() {

		List<Paciente> todosPacientes = pacienteRepository.findAll();
		if (todosPacientes.isEmpty()) {

			throw new PacienteNotFoundException("Não há pacientes cadastrados");
		}

		return todosPacientes;
	}

	public Paciente buscaPacientePeloNome(String nome) {

		try {

			Optional<Paciente> todosPaciente = pacienteRepository.findByNome(nome);
			return todosPaciente.get();

		} catch (Exception e) {
			throw new PacienteNotFoundException("Paciente não encontrado!");
		}

	}

	public Paciente inserePaciente(Paciente paciente) {

		if (paciente == null) {
			throw new PacienteNotFoundException("Erro na inserção do Paciente!");
		}

		return pacienteRepository.save(paciente);
	}

	@Override
	public Paciente alteraPaciente(Paciente paciente, Integer id) {

		Optional<Paciente> buscaPaciente = pacienteRepository.findById(id);

		if (buscaPaciente.isPresent()) {
			buscaPaciente.get().setCodigoPaciente(paciente.getCodigoPaciente());
			buscaPaciente.get().setDataNascimento(paciente.getDataNascimento());
			buscaPaciente.get().setEmail(paciente.getCpf());
			buscaPaciente.get().setEstadoCivil(paciente.getEstadoCivil());
			buscaPaciente.get().setNumeroCelular(paciente.getCpf());
			buscaPaciente.get().setSenha(paciente.getCpf());

			return buscaPaciente.get();

		} else {
			throw new PacienteNotFoundException("Erro ao alterar o Paciente");
		}

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

}
