package com.kcsitglobal.service;

import java.util.Optional;

import com.kcsitglobal.model.User;

public interface UserService {
	Integer saveUser(User user);
	Optional<User> findByUsername(String username);

}
