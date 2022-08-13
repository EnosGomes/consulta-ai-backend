package com.creta.consultaai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.domain.Consulta;
import com.creta.consultaai.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	public List<Consulta> retornaTodasConsultas() {

		List<Consulta> todasConsultas = consultaRepository.findAll();

		if (todasConsultas.isEmpty()) {
			System.out.println("empty");
			throw new RuntimeException("Não há consultas cadastrados");
		} 
		
		return todasConsultas;
	}

}
