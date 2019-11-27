package com.proyecto.app.security.security;

import java.io.Serializable;

public class Response implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5970996114616801949L;
	private String message;

	
	
	public Response(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
