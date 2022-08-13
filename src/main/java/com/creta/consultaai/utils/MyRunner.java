package com.creta.consultaai.utils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.creta.consultaai.domain.Consulta;
import com.creta.consultaai.domain.Endereco;
import com.creta.consultaai.domain.EstadoCivil;
import com.creta.consultaai.domain.Medico;
import com.creta.consultaai.domain.Paciente;
import com.creta.consultaai.repository.ConsultaRepository;
import com.creta.consultaai.repository.MedicoRepository;
import com.creta.consultaai.repository.PacienteRepository;

@Component
public class MyRunner implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
    public void run(String... args) throws Exception {
		
		//Criando um Paciente
		/*
		Endereco end1 = new Endereco("1","27","6505000","sao luis","Maranha","perto dali");
		Set<String> telefonesPaciente = new HashSet<>();
		telefonesPaciente.add("5588");
		
		Paciente p1 = new Paciente();
		p1.setNome("Enos Passarets");
		p1.setCpf("60281084300");
		p1.setDataNascimento(LocalDate.now().minusDays(120));
		p1.setEmail("enos@enos.com");
		p1.setSenha("123");
		p1.setEndereco(end1);
		p1.setEstadoCivil(EstadoCivil.CASADO);
		p1.setCodigoPaciente(1l);
		p1.setNumeroCelular("8899");
		p1.setNumeroSus("1");
		p1.setId(1l);
		p1.setTelefones(telefonesPaciente);
		
		pacienteRepository.save(p1); */
		
		//Criando um medico
		
		Endereco end2 = new Endereco("1","27","6505000","sao luis","Maranha","perto dali");
		Set<String> telefonesPaciente2 = new HashSet<>();
		telefonesPaciente2.add("5588");
		
		Paciente p2 = new Paciente();
		p2.setNome("Enos Passarets");
		p2.setCpf("60281084300");
		p2.setDataNascimento(LocalDate.now().minusDays(120));
		p2.setEmail("enos@enos.com");
		p2.setSenha("123");
		p2.setEndereco(end2);
		p2.setEstadoCivil(EstadoCivil.CASADO);
		p2.setCodigoPaciente(1l);
		p2.setNumeroCelular("8899");
		p2.setNumeroSus("1");
		p2.setTelefones(telefonesPaciente2);
		
		pacienteRepository.save(p2);
		
		Medico m1 = new Medico();
		m1.setNome("Sabrina Melo");
		m1.setCpf("26901501315");
		m1.setDataNascimento(LocalDate.now().minusDays(20));
		m1.setEmail("sabrina@sabrina.com");
		m1.setSenha("456");
		m1.setEndereco(end2);
		m1.setEstadoCivil(EstadoCivil.CASADO);
		m1.setCrm("9999");
		
		medicoRepository.save(m1);		
		
		//Criando uma consulta
		Consulta c1 = new Consulta();
		c1.setNome("Consulta 1");
		c1.setMedico(m1);
		c1.setPaciente(p2);
		
		consultaRepository.save(c1); 
		
    }

}
