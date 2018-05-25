package com.salao.v1.DTO;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.salao.v1.model.Aluguel;

public class AluguelDTO extends ResourceSupport{
	
	//Para colocar no JSON apenas se ele nao for nulo
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private Date fimAnuncio;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	public AluguelDTO() {
	}
	
	public static Aluguel build(AluguelDTO aluguelDTO) {
		Aluguel aluguel = new Aluguel();
		
			aluguel.setIdentifier(aluguelDTO.getIdentifier());
			aluguel.setFimAnuncio(aluguelDTO.getFimAnuncio());
			aluguel.setDescricao(aluguelDTO.getDescricao());
			
		return aluguel;
	}
	
	public AluguelDTO(Aluguel aluguel) {
		super();
		this.identifier = aluguel.getIdentifier();
		this.fimAnuncio = aluguel.getFimAnuncio();
		this.descricao = aluguel.getDescricao();
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public Date getFimAnuncio() {
		return fimAnuncio;
	}

	public void setFimAnuncio(Date fimAnuncio) {
		this.fimAnuncio = fimAnuncio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
