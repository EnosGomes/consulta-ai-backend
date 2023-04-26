package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.exception.HospitalNotFoundException;
import com.creta.consultaai.model.Hospital;
import com.creta.consultaai.service.impl.HospitalServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("${urlpadrao}/hospitais") 
//@RequiredArgsConstructor ao inves que autowired pode ser
public class HospitalController {		
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	HospitalServiceImpl hospitalService;

	@GetMapping(value = "/todos")
	public List<Hospital> retorneTodosHospitais() throws HospitalNotFoundException {
		List<Hospital> retornaTodosHospitais = hospitalService.retornaTodosHospitais();

		return retornaTodosHospitais;		
	}
	
	@GetMapping(value = "/id/{id}")
	public Hospital retornaHospitalPorId(@PathVariable String id) throws HospitalNotFoundException{
		Hospital retornaHospitalPorId = hospitalService.retornaHospitalPorId(id);

		return retornaHospitalPorId;		
	}
	
	@PostMapping
	public ResponseEntity<Hospital> cadastraHospital(@Valid @RequestBody Hospital hospital){
		
		hospitalService.insereHospital(hospital);
		
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(hospital.getId())
                                    .toUri();
        logger.info("Hospital criado com sucesso!");
        return ResponseEntity.created(location).build(); //rest concepts
	}
	
	@PutMapping(value = "/id/{id}")
	public ResponseEntity<Hospital> atualizaHospital(@Valid @RequestBody Hospital hospital, @PathVariable String id){
		
		hospitalService.atualizaHospitalPorId(hospital, id);
		
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(hospital.getId())
                                    .toUri();
        logger.info("Hospital editado com sucesso!");
        return ResponseEntity.created(location).build(); //rest concepts
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<List<Hospital>> retornaHospitalPorNome(@RequestParam String nome ){
		
		List<Hospital> hospitaisPorNome = hospitalService.findHospitalByNome(nome);
		
		return ResponseEntity.ok(hospitaisPorNome);
	}
	
	@GetMapping(value = "/contem")
	public ResponseEntity<List<Hospital>> retornaHospitalContemNome(@RequestParam String nome ){
		
		List<Hospital> hospitaisContendoNome = hospitalService.findHospitalContainingNome(nome);
		if(hospitaisContendoNome == null || hospitaisContendoNome.isEmpty()) {
			throw new RuntimeException("Não há hospitais contendo esse nome.");
		}
		
		return ResponseEntity.ok(hospitaisContendoNome);
	}
	
	@GetMapping(value = "/ativos")
	public ResponseEntity<List<Hospital>> retornaHospitaisAtivos(){
		
		List<Hospital> hospitaisAtivos = hospitalService.findHospitalAtivos();
		if(hospitaisAtivos == null || hospitaisAtivos.isEmpty()) {
			throw new RuntimeException("Não há hospitais ativos.");
		}
		
		return ResponseEntity.ok(hospitaisAtivos);
	}

	@DeleteMapping(value = "/id/{id}")
	public ResponseEntity<Void> excluirHospital(@PathVariable UUID id){

		hospitalService.excluirHospital(id);

		 return ResponseEntity.noContent().build();
	}
}
