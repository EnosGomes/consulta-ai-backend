package com.creta.consultaai.service;

import com.creta.consultaai.model.Consulta;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultaService {
	
	List<Consulta> retornaTodasConsultas();
	Consulta cadastraConsulta(Consulta consulta);

	List<Consulta> retornaConsultasNaoAceitasMedico();

	void deletaConsulta(UUID id);

	Optional<Consulta> findById(UUID id);

	Consulta alteraConsulta(Consulta consulta, UUID id);
}
