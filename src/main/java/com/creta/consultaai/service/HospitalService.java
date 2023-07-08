package com.creta.consultaai.service;

import java.util.List;
import java.util.UUID;

import com.creta.consultaai.model.Hospital;

import javax.mail.MessagingException;

public interface HospitalService {
	
	public List<Hospital> retornaTodosHospitais();
	public Hospital insereHospital(Hospital hospital) throws MessagingException;
	public Hospital retornaHospitalPorId(UUID id);
	public Hospital atualizaHospitalPorId(Hospital hospital, UUID id);
	public List<Hospital> findHospitalByNome(String nome);
	public List<Hospital> findHospitalContainingNome(String nome);
	public List<Hospital> findHospitalAtivos();
	void excluirHospital(UUID id);

}
