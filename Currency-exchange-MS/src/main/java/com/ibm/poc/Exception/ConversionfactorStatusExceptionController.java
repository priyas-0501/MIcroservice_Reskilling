package com.ibm.poc.Exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConversionfactorStatusExceptionController {

	@ExceptionHandler(value = ConversionExchangeStatusException.class)
	   public ResponseEntity<Object> handleexception(ConversionExchangeStatusException exception) {
		 return ResponseEntity.status(exception.getHttpStatus()).body(exception.getMessage());
	   }



}
