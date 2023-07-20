package com.creta.consultaai;

import com.creta.consultaai.model.ERole;
import com.creta.consultaai.model.Role;
import com.creta.consultaai.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaAiApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultaAiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		roleRepository.save(new Role(ERole.ROLE_ADMIN));
		roleRepository.save(new Role(ERole.ROLE_MODERATOR));
		roleRepository.save(new Role(ERole.ROLE_USER));
	}
}
