package com.web.service.model.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.model.entities.Product;
/**
 * 
 * A classe UserRepository não é necessário de annotation(Repository) pois está herdando da interface JpaRepository, que já possui a annotation implementada.
 * 
 * @author fsouviei
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
