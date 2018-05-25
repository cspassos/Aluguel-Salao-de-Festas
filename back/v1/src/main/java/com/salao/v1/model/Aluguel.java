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
	private Date fimAnuncio;
	private String descricao;
	
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
	public Long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	
}
