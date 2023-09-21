package com.nisum.crud.exception;

public class MessageErrorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageErrorException(String message) {
		super(message);
	}

}
