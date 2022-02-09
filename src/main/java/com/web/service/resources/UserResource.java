package com.web.service.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.entities.User;

/**
 * 
 * Classe responsável por disponibilizar o recurso web referente a entidade User
 * 
 * @author fsouviei
 *
 */

// @RestController -> Para falar que essa classe é um recurso web, que é implementado por um controlador REST

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// ResponseEntity - TIPO ESPECÍFICO PARA RETORNAR RESPOSTAS DE RECURSOS WEB
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","maria@gmail.com","9999999","1234");
		return ResponseEntity.ok().body(u);// retorna 'ok', resposta com sucesso, e body corpo da respota vai receber o user
	}
	
}
