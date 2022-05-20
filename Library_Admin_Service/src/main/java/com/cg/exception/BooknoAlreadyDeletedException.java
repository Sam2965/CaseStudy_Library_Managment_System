package com.cg.exception;

public class BooknoAlreadyDeletedException extends Exception {
	private static final long serialVersionUID = 1L;
	 
    //default constructor
    public BooknoAlreadyDeletedException() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    //parameterized constructor
    public BooknoAlreadyDeletedException(String message) {
         super(message);
        // TODO Auto-generated constructor stub
    }
}
