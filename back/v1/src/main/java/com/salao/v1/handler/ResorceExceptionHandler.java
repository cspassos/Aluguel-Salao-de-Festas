package com.salao.v1.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salao.v1.exception.AluguelAlreadyExistException;
import com.salao.v1.exception.AluguelNotFoundException;

@ControllerAdvice
public class ResorceExceptionHandler {
	
	//Aluguel
	
	@ExceptionHandler(AluguelNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerAluguelNotFoundException(AluguelNotFoundException e, HttpServletRequest request) {
		
		e.printStackTrace();
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus((long) 4041);
		error.setTitulo("Aluguel not found");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	//AluguelAlreadyExistException = ja existe exeção
	@ExceptionHandler(AluguelAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerAluguelAlreadyExistException(AluguelAlreadyExistException e, HttpServletRequest request) {
		
		e.printStackTrace();
		
		ErrorDetails error = new ErrorDetails();
		error.setStatus((long) 4091);
		error.setTitulo("Aluguel ja existe");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/4091");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
}
