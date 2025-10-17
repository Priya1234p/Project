package com.emss.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.emss.Dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourcesNotFound.class)
	public ResponseEntity<ErrorDetails> ResourcesNotFoundExceptions(ResourcesNotFound ex, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setDate(new Date());
		details.setMessage(ex.getMessage());
		details.setDescription(request.getDescription(true));
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
		/*
		 * // if we print "Something went wrong..." for every exception then we can use
		 * these below things return new
		 * ResponseEntity<String>("Something went wrong...",
		 * HttpStatus.INTERNAL_SERVER_ERROR);
		 */
	}
	

}
