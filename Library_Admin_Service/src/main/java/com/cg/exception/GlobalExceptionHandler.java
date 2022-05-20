package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component.
@ControllerAdvice
public class GlobalExceptionHandler  {
	//The annotation @Value is used to automatically assign a value from multiple environment such as spring environment, system environment, property files, bean objects, default value etc.
	@Value(value="${data.exception.msg}")

	private String msg;

	//here we are create custom exception for our service
	//@ExceptionHandler is an annotation for handling exceptions in specific handler classes or handler methods.
	@ExceptionHandler(value = BooknoAlreadyExistsException.class)
	public ResponseEntity<String> BooknoAlreadyExistsException(BooknoAlreadyExistsException bex)
	{
	return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
	}
	
	/*@Value(value="${data.exception.msg1}")
    private String msg1;

    @ExceptionHandler(value = BooknoAlreadyDeletedException.class)
    public ResponseEntity<String> BooknoAlreadyDeletedException(BooknoAlreadyDeletedException pae)
    {
        return new ResponseEntity<String>(msg1, HttpStatus.CONFLICT);
    }*/
}
