package com.creta.consultaai.service;

import com.creta.consultaai.model.Alerta;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

public interface AlertaService {
	
	public List<Alerta> retornaTodosAlertas();
	public Alerta insereAlerta(Alerta alerta) ;
	public Alerta retornaAlertaPorId(UUID id);
	public Alerta atualizaAlertaPorId(Alerta alerta, UUID id);
	void excluirAlerta(UUID id);

}
