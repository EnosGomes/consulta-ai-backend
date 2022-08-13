package com.creta.consultaai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creta.consultaai.domain.Clinica;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {
	
	@GetMapping
	public String getTeste() {
		return "Teste funcionando";
	}
	
	@GetMapping(value = "/clinicas")
	public List<Clinica> getClinicas(){
		List<Clinica> clinicas = new ArrayList<>();
		clinicas.add(new Clinica(1l,"cedro"));
		clinicas.add(new Clinica(2l,"gaspar"));
		
		return clinicas; //posso retornar uma estrutura de dados que o spring transforma em JSON
	}

}
