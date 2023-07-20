package com.creta.consultaai.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    List<Consulta> findByMedicoAceitouConsultaTrue();

}
