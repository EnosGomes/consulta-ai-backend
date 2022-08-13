package com.creta.consultaai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creta.consultaai.domain.Hospital;
import com.creta.consultaai.service.HospitalService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/hospitais") //api/v1/
public class HospitalController {
	
	
	//@RequiredArgsConstructor ao inves que autowired

	@Autowired
	HospitalService hospitalService;

	@GetMapping(value = "/todos")
	public List<Hospital> getAllPacientes() {

		return hospitalService.retornaTodosHospitais();
		
		
		/*
		 * if (hospitalService.isPresent()){
		 * 	
		 * 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 * 
		 * }
		 * 
		 * return  return new ResponseEntity<Hospital>(hospitalService.get(), HttpStatus.OK);
		 * 
		 * */
	}
	
	@PostMapping
	public ResponseEntity<Hospital> cadastraHospital(@Valid @RequestBody Hospital hospital){
		
		//Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(hospital.getId())
                                    .toUri();
			
        return ResponseEntity.created(location).build(); //rest concepts
	}
	
	/*
	 * public ResponseEntity<Hospital> findTaskById(Long id){
	 * return  hospitalRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(hospital))
                .orElse(ResponseEntity.notFound().build());
	 * 
	 * public ResponseEntity<Task> updateTaskById(Task task, Long id){
        return taskRepository.findById(id)
                .map(taskToUpdate ->{
                    taskToUpdate.setTitle(task.getTitle());
                    taskToUpdate.setDescription(task.getDescription());
                    taskToUpdate.setDeadLine(task.getDeadLine());
                    Task updated = taskRepository.save(taskToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return taskRepository.findById(id)
                .map(taskToDelete ->{
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }
	 * 
	 * */
	
	
	//outra forma de criar post 
	/*
	 * @PostMapping("/new")
    public String processCreationForm(Beer beer) {
        //ToDO: Add Service
        Beer newBeer = Beer.builder()
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .minOnHand(beer.getMinOnHand())
                .price(beer.getPrice())
                .quantityToBrew(beer.getQuantityToBrew())
                .upc(beer.getUpc())
                .build();

        Beer savedBeer = beerRepository.save(newBeer);
        return "redirect:/beers/" + savedBeer.getId();
	 * 
	 * */

}
