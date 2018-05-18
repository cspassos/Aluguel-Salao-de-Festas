package com.salao.v1.exception;

public class AluguelNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AluguelNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public AluguelNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
