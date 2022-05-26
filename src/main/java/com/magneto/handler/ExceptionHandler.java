package com.magneto.handler;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.magneto.constanst.StatusCode;
import com.magneto.dto.GenericResponse;
import com.magneto.handler.exception.MutantNotFoundException;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ExceptionHandler {
	
	   @ResponseStatus(
	            value = HttpStatus.NOT_FOUND)
	   @org.springframework.web.bind.annotation.ExceptionHandler(value = {MutantNotFoundException.class})
	    public ResponseEntity<GenericResponse>
	            notFoundExceptionHandler(HttpServletRequest request, Exception e) {
	        final String message =
	                (e instanceof MutantNotFoundException ) && e.getMessage() != null
	                                ? e.getMessage()
	                                : StatusCode.NOT_FOUND.getDescription();

	        GenericResponse response = new GenericResponse(StatusCode.NOT_FOUND.getCode(),message);

	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	   }
	   

	   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	   @org.springframework.web.bind.annotation.ExceptionHandler(value = {MethodArgumentNotValidException.class})
	   public ResponseEntity<GenericResponse> badRequestExceptionHandler(HttpServletRequest request, 
			   Exception e) {
		   
		   final String message =
	               e.getMessage() == null ? StatusCode.BAD_REQUEST.getDescription()
	                       : e.getMessage();

	       GenericResponse response = new GenericResponse(StatusCode.BAD_REQUEST.getCode(),message);


	       return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	   }
	   
	  @ResponseStatus(
	           value = HttpStatus.INTERNAL_SERVER_ERROR)
	  @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
	   public ResponseEntity<GenericResponse>
	   genericExceptionHandler(HttpServletRequest request, Exception e) {
		   final String message =
	               e.getMessage() == null ? StatusCode.INTERNAL_SERVER_ERROR.getDescription()
	                       : e.getMessage();

	       GenericResponse response = new GenericResponse(StatusCode.INTERNAL_SERVER_ERROR.getCode(),message);

	       return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	   }

}
