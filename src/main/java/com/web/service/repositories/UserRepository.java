package com.web.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.service.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
