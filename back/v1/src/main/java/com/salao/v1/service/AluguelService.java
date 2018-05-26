package com.salao.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salao.v1.exception.AluguelAlreadyExistException;
import com.salao.v1.exception.AluguelNotFoundException;
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
	
	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return aluguelRepository.existsById(id);
	}
	
	@Transactional(readOnly = false)
	public Aluguel save(Aluguel p) {
		if(p.getIdentifier() != null && exist(p.getIdentifier())) {
			throw new AluguelAlreadyExistException("Aluguel com esse id já existe: " + p.getIdentifier());
		}
		
		return aluguelRepository.save(p);
	}

	@Transactional(readOnly = true)
	public Aluguel findById(Long id) {
		if(!exist(id)) {
			throw new AluguelNotFoundException("Aluguel com esse id não existe: "+ id);
		}
		
		return aluguelRepository.findOne(id);
	}
	
	@Transactional(readOnly = false)
	public Aluguel update(Aluguel p) {
		if(!exist(p.getIdentifier())) {
			throw new AluguelNotFoundException("Aluguel com esse id não existe: "+ p.getIdentifier());
		}
		
		return aluguelRepository.save(p);
		
	}
	
	@Transactional(readOnly = false)
	public void delete(Aluguel p) {
		aluguelRepository.delete(p);
	}
}
