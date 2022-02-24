package com.web.service.model.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.model.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	

}
