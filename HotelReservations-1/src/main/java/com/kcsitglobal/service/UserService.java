package com.kcsitglobal.service;

import java.util.List;

import com.kcsitglobal.model.User;

public interface UserService {
	/*
	 * List<User> getAllUser();
	 * 
	 * void save(User user);
	 * 
	 * User getById(int id);
	 * 
	 * void deleteViaId(int id);
	 */

	Object findByUsername(String username);

	void save(User user);

}
