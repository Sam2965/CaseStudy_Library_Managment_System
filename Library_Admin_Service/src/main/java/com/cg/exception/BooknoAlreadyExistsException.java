package com.cg.exception;

public class BooknoAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//default constructor
	public BooknoAlreadyExistsException() { 
		super();
		// TODO Auto-generated constructor stub
	}
	//parameter constructor
	public BooknoAlreadyExistsException(String message) { 
		super(message);
		// TODO Auto-generated constructor stub
	}

}
