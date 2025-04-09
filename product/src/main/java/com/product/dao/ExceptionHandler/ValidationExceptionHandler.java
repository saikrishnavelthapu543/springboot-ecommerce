package com.product.ExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.Exception.ProductNotFoundException;
@ResponseStatus(code=HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class ValidationExceptionHandler {
	//used for client side validations
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	 //used for server side validations
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String, String> Productnotfoundhandler(ProductNotFoundException ex)
	{
	
		Map<String, String> m=new HashMap<>();
		m.put("Errormessage", ex.getMessage());
		return m;
	
	}
	
	@ExceptionHandler(SQLException.class)
	public Map<String, String> Sqlexception(SQLException ex)
	{
	
		Map<String, String> m=new HashMap<>();
		m.put("Errormessage", ex.getMessage());
		return m;
	
	}
		
	

}

