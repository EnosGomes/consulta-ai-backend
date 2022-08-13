package com.creta.consultaai.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.creta.consultaai.domain.Paciente;
import com.creta.consultaai.repository.PacienteRepository;

@Component
public class MyRunner implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
    public void run(String... args) throws Exception {

		pacienteRepository.save(new Paciente(1L, 1L,"1","333"));
		pacienteRepository.save(new Paciente(2L, 2L,"1","22"));
		pacienteRepository.save(new Paciente(3L, 3L,"1","44"));

		pacienteRepository.findAll().forEach((paciente) -> {
            logger.info("{}", paciente);
        });
    }

}
