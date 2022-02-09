package com.web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
