package com.web.service.model.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
}
