package com.web.service.controller.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.web.service.model.entities.User;
import com.web.service.model.services.UserService;

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

	@Autowired
	private UserService service;
	
	// ResponseEntity - TIPO ESPECÍFICO PARA RETORNAR RESPOSTAS DE RECURSOS WEB
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);// retorna 'ok', resposta com sucesso, e body corpo da respota vai receber o user
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping // Faz um pré processamento na compilação do compilador, definindo que este método vai receber um o método post do http
	public ResponseEntity<User> insert(@RequestBody User obj){ // @RequestBody -> Para dizer para método que esse objeto vai chegar em formato json e seria deserializado para um objeto User usamos a anotação RequestBody
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); //retorna o 204
	}
}
