package com.creta.consultaai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.creta.consultaai.exception.HospitalNotFoundException;
import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.repository.HospitalRepository;
import com.creta.consultaai.service.HospitalService;


@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private JavaMailSender mailSender;

	public List<Hospital> retornaTodosHospitais() {
		
		Optional<List<Hospital>> hospitaisNaoNulos = Optional.of(hospitalRepository.findAll());

		if (hospitaisNaoNulos.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital cadastrado!"); //criar suas proprias exceptions
		} 
		
		return hospitaisNaoNulos.get();
	}
	
	public Hospital insereHospital(Hospital hospital) throws MessagingException {
		
		Hospital hospitalCriado = new Hospital(hospital.getNome());

//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("enoskizaru@gmail.com");
//		message.setFrom("enoskizaru@gmail.com");
//		message.setSubject("Consulta Ai Sistemas");
//		message.setText("<h1>Enos</h1>");

		MimeMessage mensagem = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mensagem, false, "utf-8");

		helper.setFrom("enoskizaru@gmail.com");
		helper.setTo("enoskizaru@gmail.com");
		helper.setSubject("Consulta Ai Sistemas");
		mensagem.setContent("<h1>Enos html </h1>", "text/html");

		try {
			mailSender.send(mensagem);

		} catch (Exception e) {
			e.printStackTrace();
			throw new HospitalNotFoundException("Não foi possível enviar o email!");
		}
		
		return hospitalRepository.save(hospitalCriado);
	}

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
	
	public List<Hospital> findHospitalByNome(String nome) {
		
		Optional<List<Hospital>> hospitaisByNome = Optional.of(hospitalRepository.findByNome(nome));
		
		if(!hospitaisByNome.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado com esse nome.");
		}
		
		return hospitaisByNome.get();
	}
	
	public List<Hospital> findHospitalContainingNome(String nome) {
		
		Optional<List<Hospital>> hospitaisContainingNome = Optional.of(hospitalRepository.findByNomeContaining(nome));
		
		if(!hospitaisContainingNome.get().isEmpty()) {
			throw new HospitalNotFoundException("Nenhum hospital foi encontrado contendo esse nome");
		}
		
		return hospitaisContainingNome.get();
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
