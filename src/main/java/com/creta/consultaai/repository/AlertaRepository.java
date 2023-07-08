package com.creta.consultaai.repository;

import com.creta.consultaai.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Integer> {
	
	List<Alerta> findByNome(String nome);
	List<Alerta> findByNomeLike(String nome);
	List<Alerta> findByNomeContaining(String nome);
	Optional<Alerta> findById(UUID id);
}
