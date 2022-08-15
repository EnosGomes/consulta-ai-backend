package com.creta.consultaai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creta.consultaai.model.Requisicao;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {

}
