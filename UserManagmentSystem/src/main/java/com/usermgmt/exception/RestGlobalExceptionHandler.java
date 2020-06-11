package com.usermgmt.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class RestGlobalExceptionHandler {

	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handleDuplicateDataException() {
		ErrorMessage e = new ErrorMessage(400,"User already exists with the firstName/LastName combination",new Date());
		return new ResponseEntity<ErrorMessage>(e,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=NoUserExistsException.class)
	public ResponseEntity<ErrorMessage> handleNoUserException() {
		ErrorMessage e = new ErrorMessage(400,"User not exists with the provided id",new Date());
		return new ResponseEntity<ErrorMessage>(e,HttpStatus.BAD_REQUEST);
	}
}
