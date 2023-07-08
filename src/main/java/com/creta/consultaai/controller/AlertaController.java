package com.creta.consultaai.controller;

import com.creta.consultaai.exception.AlertaNotFoundException;
import com.creta.consultaai.model.Alerta;
import com.creta.consultaai.service.impl.AlertaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("${urlpadrao}/alertas") 
//@RequiredArgsConstructor ao inves que autowired pode ser
public class AlertaController {		
	
	private static final Logger logger = LoggerFactory.getLogger(AlertaController.class);

	@Autowired
	AlertaServiceImpl alertaService;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping(value = "/todos")
	public List<Alerta> retorneTodosAlertas() throws AlertaNotFoundException {
		List<Alerta> retornaTodosAlertas = alertaService.retornaTodosAlertas();

		return retornaTodosAlertas;		
	}
	
	@GetMapping(value = "/id/{id}")
	public Alerta retornaAlertaPorId(@PathVariable UUID id) throws AlertaNotFoundException {
		Alerta retornaAlertaPorId = alertaService.retornaAlertaPorId(id);

		return retornaAlertaPorId;		
	}
	
	@PostMapping
	public ResponseEntity<Alerta> cadastraAlerta(@Valid @RequestBody Alerta alerta) throws MessagingException {
		
		alertaService.insereAlerta(alerta);
		
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(alerta.getId())
                                    .toUri();
        logger.info("Alerta criado com sucesso!");
        return ResponseEntity.created(location).build(); //rest concepts
	}
	
	@PutMapping(value = "/id/{id}")
	public ResponseEntity<Alerta> atualizaAlerta(@Valid @RequestBody Alerta alerta, @PathVariable UUID id) {
		
		alertaService.atualizaAlertaPorId(alerta, id);
		
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(alerta.getId())
                                    .toUri();
        logger.info("Alerta editado com sucesso!");
        return ResponseEntity.created(location).build(); //rest concepts
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<List<Alerta>> retornaAlertaPorNome(@RequestParam String nome) {
		
		List<Alerta> alertasPorNome = alertaService.findAlertaByNome(nome);
		
		return ResponseEntity.ok(alertasPorNome);
	}
	
	@GetMapping(value = "/contem")
	public ResponseEntity<List<Alerta>> retornaAlertaContemNome(@RequestParam String nome) {
		
		List<Alerta> alertasContendoNome = alertaService.findAlertaContainingNome(nome);
		if(alertasContendoNome == null || alertasContendoNome.isEmpty()) {
			throw new RuntimeException("Não há alertas contendo esse nome.");
		}
		
		return ResponseEntity.ok(alertasContendoNome);
	}

	@DeleteMapping(value = "/id/{id}")
	public ResponseEntity<Void> excluirAlerta(@PathVariable UUID id) {

		alertaService.excluirAlerta(id);

		 return ResponseEntity.noContent().build();
	}
}