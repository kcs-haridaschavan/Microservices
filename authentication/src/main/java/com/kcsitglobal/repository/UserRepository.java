package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
