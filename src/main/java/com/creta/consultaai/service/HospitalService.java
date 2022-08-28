package com.creta.consultaai.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.HospitalNotFoundException;
import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.repository.HospitalRepository;

@Service
public class HospitalService {

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
	
	public Hospital retornaHospitalPorId(Integer id) {
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		if(!hospital.isPresent()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado com esse Id.");
		}
		
		return hospital.get();
	}
	
	public Hospital atualizaHospitalPorId(Hospital hospital, Integer id) {
		
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
			throw new HospitalNotFoundException("Nenhum hospital ativo foi encontado.");
		}
		
		return hospitaisAtivos.get();
	}
}
