package com.creta.consultaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creta.consultaai.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
