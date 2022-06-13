package com.kcsitglobal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.entity.User;

/**
 * 
 * @author haridas.chavan
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * 
	 * @param username
	 * @return
	 */

	Optional<User> findByUsername(String username);

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */

	public User findByUsernameAndPassword(String username, String password);
}
