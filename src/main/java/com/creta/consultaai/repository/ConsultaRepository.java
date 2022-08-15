package com.creta.consultaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
