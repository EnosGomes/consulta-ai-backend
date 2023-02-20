package com.creta.consultaai.mapper;

import com.creta.consultaai.dto.PacienteDTO;
import com.creta.consultaai.model.Paciente;

public class PacienteMapper {

	// pode ser um paciente request que o que vai receber do Postman
	public static Paciente toPaciente(PacienteDTO pacienteDTO) {
		Paciente paciente = new Paciente();
		paciente.setNome(pacienteDTO.getNome());
		paciente.setDataNascimento(pacienteDTO.getDataNascimento());
		paciente.setCpf(pacienteDTO.getCpf());
		paciente.setEmail(pacienteDTO.getEmail());
		paciente.setSenha(pacienteDTO.getSenha());
		paciente.setCodigoPaciente(pacienteDTO.getCodigoPaciente());
		paciente.setNumeroSus(pacienteDTO.getNumeroSus());
		paciente.setNumeroCelular(pacienteDTO.getNumeroCelular());
		paciente.setConsultas(pacienteDTO.getConsultas());

		return paciente;
	}

	// Pode ser um Paciente Response o nome ja que é a volta
	public static PacienteDTO toPacienteDTO(Paciente paciente) {

		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setCodigoPaciente(paciente.getCodigoPaciente());
		pacienteDTO.setNumeroSus(paciente.getNumeroSus());
		pacienteDTO.setNumeroCelular(paciente.getNumeroCelular());
		pacienteDTO.setConsultas(paciente.getConsultas());

		return pacienteDTO;
	}

}
