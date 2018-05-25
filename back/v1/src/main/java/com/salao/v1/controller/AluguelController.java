package com.salao.v1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salao.v1.DTO.AluguelDTO;
import com.salao.v1.model.Aluguel;
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
}
