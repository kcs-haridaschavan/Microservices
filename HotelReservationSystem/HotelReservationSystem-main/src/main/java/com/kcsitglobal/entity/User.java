package com.kcsitglobal.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author haridas.chavan
 *
 */

@Entity
//@Table(name = "user")

public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String username;
	private String password;
	@ElementCollection
	private List<String> roles;

	/**
	 * Default Constructor
	 */
	public User() {

	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param username
	 * @param password
	 * @param roles
	 */

	public User(Integer id, String name, String username, String password, List<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * 
	 * @returnid
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * 
	 * @param roles
	 */

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
