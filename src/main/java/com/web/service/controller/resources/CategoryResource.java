package com.web.service.controller.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.model.entities.Category;
import com.web.service.model.services.CategoryService;

/**
 * 
 * Classe responsável por disponibilizar o recurso web referente a entidade Category
 * 
 * @author fsouviei
 *
 */

// @RestController -> Para falar que essa classe é um recurso web, que é implementado por um controlador REST

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	// ResponseEntity - TIPO ESPECÍFICO PARA RETORNAR RESPOSTAS DE RECURSOS WEB
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);// retorna 'ok', resposta com sucesso, e body corpo da respota vai receber o Category
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
