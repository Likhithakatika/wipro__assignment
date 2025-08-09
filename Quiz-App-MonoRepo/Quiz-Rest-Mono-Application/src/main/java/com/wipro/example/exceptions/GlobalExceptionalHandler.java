package com.wipro.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {
	
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleQuestionNotFoundException(QuestionNotFoundException qe){
		ErrorMessage errorMessage = new ErrorMessage("QuestionNotFoundException", qe.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
