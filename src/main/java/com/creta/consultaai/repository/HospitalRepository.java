package com.creta.consultaai.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, UUID> {
	
	List<Hospital> findByNome(String nome);
	List<Hospital> findByNomeLike(String nome);
	List<Hospital> findByNomeContaining(String nome);
	List<Hospital> findByAtivoTrue();
}
