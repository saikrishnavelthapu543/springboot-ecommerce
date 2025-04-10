package com.example.Exceptionhandler;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> Exception1(MethodArgumentNotValidException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> Exception2(SQLException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
