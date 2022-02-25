package com.web.service.controller.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.web.service.model.services.exceptions.DatabaseException;
import com.web.service.model.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Intercepta as excecoes que acontecerem p/ q objeto possa executar um possivel tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)//Com essa anotação, eu estou falando para o sistema, interceptar qualquer excecão do tipo ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	@ExceptionHandler(DatabaseException.class)//Com essa anotação, eu estou falando para o sistema, interceptar qualquer excecão do tipo ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(DatabaseException e, HttpServletRequest request){
		String error = "Erro de banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
}
