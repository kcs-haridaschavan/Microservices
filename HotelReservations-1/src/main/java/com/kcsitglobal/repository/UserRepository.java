package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
