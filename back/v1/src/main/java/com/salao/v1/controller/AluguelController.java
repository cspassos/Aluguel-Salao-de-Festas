package com.salao.v1.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salao.v1.DTO.AluguelDTO;
import com.salao.v1.model.Aluguel;
import com.salao.v1.repository.AluguelRepository;
import com.salao.v1.service.AluguelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/aluguels")
public class AluguelController { 

	@Autowired
	private AluguelService aluguelService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<AluguelDTO>> listarTodos(){
		
		List<Aluguel> aluguels = aluguelService.findAll();
		List<AluguelDTO> aluguelDTO = new ArrayList<>();
		
		for (Aluguel aluguel : aluguels) {
			aluguelDTO.add(new AluguelDTO(aluguel));
		}
		
		return ResponseEntity.ok(aluguelDTO);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<AluguelDTO> findById(@PathVariable("id") Long id){
		
		Aluguel aluguel = aluguelService.findById(id);
		AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
		
		return ResponseEntity.ok(aluguelDTO);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody AluguelDTO aluguelDTO){
		
		Aluguel aluguel = aluguelService.save(AluguelDTO.build(aluguelDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluguel.getIdentifier()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody AluguelDTO aluguelDTO, @PathVariable("id") Long id){
		
		aluguelDTO.setIdentifier(id);
		aluguelService.update(AluguelDTO.build(aluguelDTO));
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<AluguelDTO> delete(@PathVariable("id") Long id){
		
		Aluguel aluguel = aluguelService.findById(id);
		AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
		aluguelService.delete(aluguel);
		
		return ResponseEntity.ok(aluguelDTO);
	}
}
