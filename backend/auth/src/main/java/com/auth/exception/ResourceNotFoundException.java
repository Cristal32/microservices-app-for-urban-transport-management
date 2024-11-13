package com.auth.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8785901847928873045L;

	// Constructor with only a message
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	// Constructor with a message and a cause
	public ResourceNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
