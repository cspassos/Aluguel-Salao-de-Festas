package com.salao.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salao.v1.model.Aluguel;
import com.salao.v1.repository.AluguelRepository;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	//readOnly = true = apenas leitura/consulta
	@Transactional(readOnly = true)
	public List<Aluguel> findAll(){
		return aluguelRepository.findAll();
	}
}
