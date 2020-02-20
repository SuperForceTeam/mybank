package com.superforce.mybank.exception;

public class AccountCreationFailedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountCreationFailedException(String message) {
		super(message);
	}

}
