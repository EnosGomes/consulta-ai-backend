package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.HospitalNotFoundException;
import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.repository.HospitalRepository;
import com.creta.consultaai.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> retornaTodosHospitais() {
		
		Optional<List<Hospital>> hospitaisNaoNulos = Optional.of(hospitalRepository.findAll());

		if (hospitaisNaoNulos.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital cadastrado!"); //criar suas proprias exceptions
		} 
		
		return hospitaisNaoNulos.get();
	}
	
	public Hospital insereHospital(Hospital hospital) {
		
		Hospital hospitalCriado = new Hospital(hospital.getNome());
		
		return hospitalRepository.save(hospitalCriado);
	}
	
	public Hospital retornaHospitalPorId(String id) {
		Optional<Hospital> hospital = Optional.ofNullable(hospitalRepository.findAll().get(0));
		if(!hospital.isPresent()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado com esse Id.");
		}
		
		return hospital.get();
	}
	
	public Hospital atualizaHospitalPorId(Hospital hospital, String id) {
		
		Hospital hospitalBuscado = this.retornaHospitalPorId(id);
		
		if(hospital == null) {
			throw new HospitalNotFoundException("Nenhum hospital com esse id foi encontado para ser atualizado.");
		}		
		
		hospitalBuscado.setNome(hospital.getNome());
		return hospitalRepository.save(hospitalBuscado);
	}
	
	public List<Hospital> findHospitalByNome(String nome) {
		
		Optional<List<Hospital>> hospitaisByNome = Optional.of(hospitalRepository.findByNome(nome));
		
		if(!hospitaisByNome.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado com esse nome.");
		}
		
		return hospitaisByNome.get();
	}
	
	public List<Hospital> findHospitalContainingNome(String nome) {
		
		Optional<List<Hospital>> hospitaisContainingNome = Optional.of(hospitalRepository.findByNomeContaining(nome));
		
		if(!hospitaisContainingNome.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado contendo esse nome");
		}
		
		return hospitaisContainingNome.get();
	}
	
	public List<Hospital> findHospitalAtivos() {
		
		Optional<List<Hospital>> hospitaisAtivos = Optional.of(hospitalRepository.findByAtivoTrue());
		
		if(hospitaisAtivos.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital ativo foi encontrado.");
		}
		
		return hospitaisAtivos.get();
	}


	public void excluirHospital(UUID id) {

		Optional<Hospital> hospitalEncontrado =  hospitalRepository.findById(id);
		if(hospitalEncontrado.isPresent()){
			hospitalRepository.delete(hospitalEncontrado.get());
		} else {
			throw new HospitalNotFoundException("Nenhum hospital ativo foi encontrado.");
		}

	}
}
