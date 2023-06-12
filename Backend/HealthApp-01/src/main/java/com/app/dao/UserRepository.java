package com.app.dao;


import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailAndPassword(String email, String pass);
	User findByEmail(String email);
	
}
