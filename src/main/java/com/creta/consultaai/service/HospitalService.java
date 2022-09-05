package com.creta.consultaai.service;

import java.util.List;

import com.creta.consultaai.model.Hospital;

public interface HospitalService {
	
	public List<Hospital> retornaTodosHospitais();
	public Hospital insereHospital(Hospital hospital);
	public Hospital retornaHospitalPorId(Integer id);
	public Hospital atualizaHospitalPorId(Hospital hospital, Integer id);
	public List<Hospital> findHospitalByNome(String nome);
	public List<Hospital> findHospitalContainingNome(String nome);
	public List<Hospital> findHospitalAtivos();

}
