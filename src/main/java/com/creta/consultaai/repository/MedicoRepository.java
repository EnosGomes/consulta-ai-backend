package com.creta.consultaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
