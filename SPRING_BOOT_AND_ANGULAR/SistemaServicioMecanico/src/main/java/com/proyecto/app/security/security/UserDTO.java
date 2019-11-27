package com.proyecto.app.security.security;

import java.io.Serializable;

import com.proyecto.app.models.User;

public class UserDTO  implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2395944276288394246L;
	
	private User user;
	private String token;
	
	public UserDTO(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
