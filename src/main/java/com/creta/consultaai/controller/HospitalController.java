package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.service.HospitalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("${url.padrao}/hospitais") 
public class HospitalController {	
	
	//@RequiredArgsConstructor ao inves que autowired pode ser
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	HospitalService hospitalService;

	@GetMapping(value = "/todos")
	public List<Hospital> retorneTodosHospitais() {
		List<Hospital> retornaTodosHospitais = hospitalService.retornaTodosHospitais();
		
		if(retornaTodosHospitais == null || retornaTodosHospitais.isEmpty()) {
			throw new RuntimeException("Não existe hospitais cadastrados");
		}

		return hospitalService.retornaTodosHospitais();
		
	}
	//receber um HospitalDTO
	@PostMapping
	public ResponseEntity<Hospital> cadastraHospital(@Valid @RequestBody Hospital hospital){
		
		hospitalService.insereHospital(hospital);
		
		//Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(hospital.getId())
                                    .toUri();
        logger.info("Hospital criado com sucesso!");
        return ResponseEntity.created(location).build(); //rest concepts
	}
	

}
