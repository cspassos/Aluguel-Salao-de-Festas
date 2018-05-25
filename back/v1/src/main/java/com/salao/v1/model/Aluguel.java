package com.salao.v1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identifier;
	private String fimAnuncio;
	private String descricao;
	
	public String getFimAnuncio() {
		return fimAnuncio;
	}
	public void setFimAnuncio(String fimAnuncio) {
		this.fimAnuncio = fimAnuncio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	
}
