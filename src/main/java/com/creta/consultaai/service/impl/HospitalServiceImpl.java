package com.creta.consultaai.service.impl;

import com.creta.consultaai.exception.HospitalNotFoundException;
import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.repository.HospitalRepository;
import com.creta.consultaai.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class HospitalServiceImpl implements HospitalService{

	private static ExecutorService executorService = Executors.newFixedThreadPool(1);

	@Autowired
	private HospitalRepository hospitalRepository;

//	@Autowired
//	private JavaMailSender mailSender;

	public List<Hospital> retornaTodosHospitais() {
		
		Optional<List<Hospital>> hospitaisNaoNulos = Optional.of(hospitalRepository.findAll());

		if (hospitaisNaoNulos.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital cadastrado!"); //criar suas proprias exceptions
		} 
		
		return hospitaisNaoNulos.get();
	}
	
	public Hospital insereHospital(Hospital hospital) throws MessagingException {

		//enviarEmailHospitalCadastrado(hospital);
		Hospital hospitalCriado = new Hospital(hospital.getNome(), hospital.getCnes());
		return hospitalRepository.save(hospitalCriado);
	}

//	public void enviarEmailHospitalCadastrado(Hospital hospital) throws MessagingException, jakarta.mail.MessagingException {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("enoskizaru@gmail.com");
//		message.setFrom("enoskizaru@gmail.com");
//		message.setSubject("Consulta Ai Sistemas");
//		message.setText("<h1>Enos</h1>");
//
//		MimeMessage mensagem = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mensagem, false, "utf-8");
//		String html = ""; //depois um builder
//
//		helper.setFrom("enoskizaru@gmail.com");
//		helper.setTo("enoskizaru@gmail.com");
//		helper.setSubject("Consulta Ai Sistemas");
//		html = "<h1>" + hospital.getNome() + "</h1>";
//		mensagem.setContent(html, "text/html");
//
//		try {
//			mailSender.send(mensagem);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new HospitalNotFoundException("Não foi possível enviar o email!");
//		}
//	}

	public Hospital retornaHospitalPorId(UUID id) {
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		if(!hospital.isPresent()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado com esse Id.");
		}
		
		return hospital.get();
	}
	
	public Hospital atualizaHospitalPorId(Hospital hospital, UUID id) {
		
		Hospital hospitalBuscado = this.retornaHospitalPorId(id);
		
		if(hospital == null) {
			throw new HospitalNotFoundException("Nenhum hospital com esse id foi encontado para ser atualizado.");
		}		
		
		hospitalBuscado.setNome(hospital.getNome());
		hospitalBuscado.setAtivo(hospital.getAtivo());
		return hospitalRepository.save(hospitalBuscado);
	}
	
	public List<Hospital> findHospitalAtivos() {
		
		Optional<List<Hospital>> hospitaisAtivos = Optional.of(hospitalRepository.findByAtivoTrue());
		
		if(hospitaisAtivos.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital ativo foi encontrado.");
		}
		
		return hospitaisAtivos.get();
	}


	public void excluirHospital(UUID id) {
		Optional<Hospital> hospitalEncontrado =  hospitalRepository.findById(id);
		if(hospitalEncontrado.isPresent()){
			hospitalRepository.delete(hospitalEncontrado.get());
		} else {
			throw new HospitalNotFoundException("Nenhum hospital ativo foi encontrado.");
		}

	}
}
