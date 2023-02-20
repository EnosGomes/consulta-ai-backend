package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.PacienteNotFoundException;
import com.creta.consultaai.model.Medico;
import com.creta.consultaai.repository.MedicoRepository;
import com.creta.consultaai.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

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

	@Override
	public Medico insereMedico(Medico medico) {
		//try catch sempre
		
		try {
			return medicoRepository.save(medico);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Nao deu para salvar esse cara ow");
		}
		
	}

	@Override
	public Medico alteraMedico(Medico medico, Integer id) {
		Optional<Medico> buscaMedico = medicoRepository.findById(id);

		if (buscaMedico.isPresent()) {
			buscaMedico.get().setCrm(medico.getCrm());
			buscaMedico.get().setEmail(medico.getEmail());
			buscaMedico.get().setDataNascimento(medico.getDataNascimento());

			return buscaMedico.get();

		} else {
			throw new PacienteNotFoundException("Erro ao alterar o Paciente");
		}
	}

	@Override
	public void deletaMedico(Integer id) {
		Optional<Medico> buscaMedico = medicoRepository.findById(id);

		if (buscaMedico.isPresent()) {
			medicoRepository.delete(buscaMedico.get());
		} else {
			throw new PacienteNotFoundException("Erro ao deletar o Medico");
		}
	}

	@Override
	public Medico retornaMedicoPorId(Integer id) {
		Optional<Medico> todosMedicos = medicoRepository.findById(id);

		if (todosMedicos.isPresent()) {
			return todosMedicos.get();
		}

		throw new RuntimeException("Não foi encontrado nenhum médico com esse id.");
	}

}
