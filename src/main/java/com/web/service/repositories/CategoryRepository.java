package com.web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
}
