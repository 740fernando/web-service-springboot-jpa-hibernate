package com.web.service.model.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
