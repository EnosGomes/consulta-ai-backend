package com.creta.consultaai.controller;

import com.creta.consultaai.exception.ConsultaNotFoundException;
import com.creta.consultaai.model.Consulta;
import com.creta.consultaai.service.impl.ConsultaServiceImpl;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "${urlpadrao}/consultas")
public class ConsultaController {

	@Autowired
	ConsultaServiceImpl consultaService;

	@GetMapping(value = "/todos")
	public List<Consulta> getAllConsultas() throws ConsultaNotFoundException{

		return consultaService.retornaTodasConsultas();
	}

	@PostMapping
	public ResponseEntity<Consulta> insereConsulta(@Valid @RequestBody Consulta consulta) {

		consultaService.cadastraConsulta(consulta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consulta.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Consulta> alteraConsulta(@Valid @RequestBody Consulta consulta, @PathVariable UUID id) {

		consultaService.alteraConsulta(consulta, id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/espera")
	public List<Consulta> getAllConsultasNaoAceitasPeloMedico() throws ConsultaNotFoundException{

		return consultaService.retornaConsultasNaoAceitasMedico();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletaConsulta(@PathVariable UUID id) {

		consultaService.deletaConsulta(id);

		return ResponseEntity.noContent().build();
	}

}
