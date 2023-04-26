package com.creta.consultaai.service;

import java.util.List;
import java.util.UUID;

import com.creta.consultaai.model.Hospital;

public interface HospitalService {
	
	public List<Hospital> retornaTodosHospitais();
	public Hospital insereHospital(Hospital hospital);
	public Hospital retornaHospitalPorId(String id);
	public Hospital atualizaHospitalPorId(Hospital hospital, String id);
	public List<Hospital> findHospitalByNome(String nome);
	public List<Hospital> findHospitalContainingNome(String nome);
	public List<Hospital> findHospitalAtivos();
	void excluirHospital(UUID id);

}
