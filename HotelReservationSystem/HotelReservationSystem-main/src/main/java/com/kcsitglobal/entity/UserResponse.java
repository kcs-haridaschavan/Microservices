package com.kcsitglobal.entity;

/**
 * 
 * @author haridas.chavan
 *
 */

public class UserResponse {

	private String token;
	private String note;

	/**
	 * 
	 * @param token
	 * @param note
	 */
	public UserResponse(String token, String note) {

		this.token = token;
		this.note = note;
	}

	/***
	 * Default Constructor
	 */

	public UserResponse() {

	}

	/**
	 * 
	 * @return token
	 */

	public String getToken() {
		return token;
	}

	/**
	 * 
	 * @param token
	 */

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 
	 * @return note
	 */

	public String getNote() {
		return note;
	}

	/**
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
