package com.creta.consultaai.mapper;

import com.creta.consultaai.dto.MedicoDTO;
import com.creta.consultaai.model.Medico;

public class MedicoMapper {
	public static Medico toMedico(MedicoDTO medicoDto) {
		Medico medico = new Medico();
		medico.setCpf(medicoDto.getCpf());
		
		return medico;
	}
	
	public static MedicoDTO toMedicoDTO(Medico medico) {
		MedicoDTO medicoDTO = new MedicoDTO();
		medicoDTO.setNome(medico.getNome());
		
		return medicoDTO;
	}

}
