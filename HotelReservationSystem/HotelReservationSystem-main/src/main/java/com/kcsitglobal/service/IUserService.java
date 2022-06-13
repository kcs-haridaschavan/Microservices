package com.kcsitglobal.service;

import com.kcsitglobal.entity.User;

public interface IUserService {
	/**
	 * 
	 * @param user
	 * @return
	 */

	public Integer saveUser(User user);

	/***
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

}
