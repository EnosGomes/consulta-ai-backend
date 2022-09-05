package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.model.Atendente;
import com.creta.consultaai.repository.AtendenteRepository;
import com.creta.consultaai.service.AtendenteService;

@Service
public class AtendenteServiceImpl implements AtendenteService{

	@Autowired
	private AtendenteRepository atendenteRepository;

	public List<Atendente> retornaTodosAtendentes() {

		List<Atendente> todosAtendentes = atendenteRepository.findAll();

		if (todosAtendentes.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há atendentes cadastrados");
		} 
		
		return todosAtendentes;
	}
	
	public Atendente retornaAtendentePorId(Long id){
		
		Optional<Atendente> todosAtendentes = atendenteRepository.findById(id);
		
		if(todosAtendentes.isPresent()) {
			return todosAtendentes.get();
		}
		
		throw new RuntimeException("Não foi encontrado nenhum atendente com esse id.");
		
	}

}
