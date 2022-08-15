package com.creta.consultaai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.model.Requisicao;
import com.creta.consultaai.repository.RequisicaoRepository;

@Service
public class RequisicaoService {

	@Autowired
	private RequisicaoRepository requisicaoRepository;

	public List<Requisicao> retornaTodosRequisicoes() {

		List<Requisicao> todasRequisicoes = requisicaoRepository.findAll();

		if (todasRequisicoes.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há requisições cadastrados");
		} 
		
		return todasRequisicoes;
	}
	
	public Requisicao retornaRequisicaoPorId(Long id){
		
		Optional<Requisicao> todasRequisicoes = requisicaoRepository.findById(id);
		
		if(todasRequisicoes.isPresent()) {
			return todasRequisicoes.get();
		}
		
		throw new RuntimeException("Não foi encontrado nenhuma requisição com esse id.");
	}

}
