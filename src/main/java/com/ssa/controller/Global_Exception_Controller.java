package com.ssa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssa.exception_handling.NOSSA_IDFOUND;

@RestController
@RestControllerAdvice
public class Global_Exception_Controller {
	 
	
	
	
	@ExceptionHandler(NOSSA_IDFOUND.class)
	public ResponseEntity<String> handling_exceptions_globally(Model u)
	{
	
	 
		String msg = "Not avialble ,Try another time....";
        ResponseEntity r2 = new ResponseEntity(msg, HttpStatus.ACCEPTED);
        return r2;
	}
	
	
	
	
	 
	

}
