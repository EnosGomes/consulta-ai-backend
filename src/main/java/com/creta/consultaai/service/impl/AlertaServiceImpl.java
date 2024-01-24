package com.creta.consultaai.service.impl;

import com.creta.consultaai.exception.AlertaNotFoundException;
import com.creta.consultaai.model.Alerta;
import com.creta.consultaai.repository.AlertaRepository;
import com.creta.consultaai.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class AlertaServiceImpl implements AlertaService{

	@Autowired
	private AlertaRepository alertaRepository;

	//@Autowired
	//private JavaMailSender mailSender;

	public List<Alerta> retornaTodosAlertas() {
		
		Optional<List<Alerta>> alertasNaoNulos = Optional.of(alertaRepository.findAll());

		if (alertasNaoNulos.get().isEmpty()) {
			throw new AlertaNotFoundException("Nenhum alerta cadastrado!"); //criar suas proprias exceptions
		}
		return alertasNaoNulos.get();
	}
	
	public Alerta insereAlerta(Alerta alerta) {
		
		Alerta alertaCriado = new Alerta(alerta.getNome());
		alertaCriado.setDescricao(alerta.getDescricao());
		return alertaRepository.save(alertaCriado);
	}

	public Alerta retornaAlertaPorId(UUID id) {
		Optional<Alerta> alerta = alertaRepository.findById(id);
		if(!alerta.isPresent()) {
			throw new AlertaNotFoundException("Nenhum alerta foi encontrado com esse Id.");
		}
		
		return alerta.get();
	}
	
	public Alerta atualizaAlertaPorId(Alerta alerta, UUID id) {
		
		Alerta alertaBuscado = this.retornaAlertaPorId(id);
		
		if(alerta == null) {
			throw new AlertaNotFoundException("Nenhum alerta com esse id foi encontado para ser atualizado.");
		}		
		
		alertaBuscado.setNome(alerta.getNome());
		return alertaRepository.save(alertaBuscado);
	}


	public void excluirAlerta(UUID id) {
		Optional<Alerta> alertaEncontrado =  alertaRepository.findById(id);
		if(alertaEncontrado.isPresent()){
			alertaRepository.delete(alertaEncontrado.get());
		} else {
			throw new AlertaNotFoundException("Nenhum alerta ativo foi encontrado.");
		}

	}
}
