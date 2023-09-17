package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.creta.consultaai.model.Paciente;
import com.creta.consultaai.model.StatusConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.ConsultaNotFoundException;
import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.repository.ConsultaRepository;
import com.creta.consultaai.service.ConsultaService;

@Service //fazer as interfaces e implementacoes
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private MedicoServiceImpl medicoService;

	@Autowired
	private PacienteServiceImpl pacienteService;

	public List<Consulta> retornaTodasConsultas() {

		List<Consulta> todasConsultas = consultaRepository.findAll();

		if (todasConsultas.isEmpty()) {
			System.out.println("empty");
			throw new ConsultaNotFoundException("Não há consultas cadastrados");
		} 
		
		return todasConsultas;
	}
	//pensar em um @transactional
	public Consulta cadastraConsulta(Consulta consulta) {

		Consulta novaConsulta = new Consulta();

		novaConsulta.setNome(consulta.getNome());
		novaConsulta.setMedico(consulta.getMedico());
		novaConsulta.setPaciente(consulta.getPaciente());
		novaConsulta.setMedicoAceitouConsulta(true);
		
		return consultaRepository.save(novaConsulta);
	}

	@Override
	public List<Consulta> retornaConsultasNaoAceitasMedico() {
		return consultaRepository.findByMedicoAceitouConsultaTrue();
	}

	@Override
	public void deletaConsulta(Integer id) {
		consultaRepository.delete(consultaRepository.findById(id).get());
	}

	@Override
	public Optional<Consulta> findById(Integer id) {
		return consultaRepository.findById(id);
	}

	@Override
	public Consulta alteraConsulta(Consulta consulta, Integer id) {

		Consulta consultaBuscada = this.findById(id).get();
		if(consultaBuscada == null){
			throw  new RuntimeException("Consulta não encontrada para alteração!");
		}

		consultaBuscada.setNome(consulta.getNome());
		consultaBuscada.setStatusConsulta(StatusConsulta.AGENDADA);
		//consultaBuscada.setMedicoAceitouConsulta(consulta.isMedicoAceitouConsulta());

		return consultaRepository.save(consultaBuscada);
	}

	public void associalPacienteNaConsulta(Integer idConsulta ,Integer idPaciente){
		Consulta consultaEncontrada = consultaRepository.findById(idConsulta).get();
		Paciente pacienteEncontrado = pacienteService.retornaPacientePorId(idPaciente);
		consultaEncontrada.adicionaPacienteNaConsulta(pacienteEncontrado);

	}

}
