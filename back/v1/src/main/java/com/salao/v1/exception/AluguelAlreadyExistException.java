package com.salao.v1.exception;

public class AluguelAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AluguelAlreadyExistException(String mensagem) {
		super(mensagem);
	}
	
	public AluguelAlreadyExistException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
