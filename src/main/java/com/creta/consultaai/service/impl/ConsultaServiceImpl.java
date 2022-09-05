package com.creta.consultaai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.ConsultaNotFoundException;
import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.repository.ConsultaRepository;
import com.creta.consultaai.service.ConsultaService;

@Service //fazer as interfaces e implementacoes
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaRepository consultaRepository;

	public List<Consulta> retornaTodasConsultas() {

		List<Consulta> todasConsultas = consultaRepository.findAll();

		if (todasConsultas.isEmpty()) {
			System.out.println("empty");
			throw new ConsultaNotFoundException("Não há consultas cadastrados");
		} 
		
		return todasConsultas;
	}
	//pensar em um @transactional
	public Consulta cadastraConsulta(Consulta consulta) {
		
		return consultaRepository.save(consulta);
	}

}
