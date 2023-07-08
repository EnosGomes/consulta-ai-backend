package com.creta.consultaai.service;

import com.creta.consultaai.model.Alerta;
import jakarta.mail.MessagingException;

import java.util.List;
import java.util.UUID;

public interface AlertaService {
	
	public List<Alerta> retornaTodosAlertas();
	public Alerta insereAlerta(Alerta alerta) throws MessagingException;
	public Alerta retornaAlertaPorId(UUID id);
	public Alerta atualizaAlertaPorId(Alerta alerta, UUID id);
	public List<Alerta> findAlertaByNome(String nome);
	public List<Alerta> findAlertaContainingNome(String nome);
	void excluirAlerta(UUID id);

}
