package com.example.SpringWebBasic.controller;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.SpringWebBasic.DTO.CustomeResponse;
import com.example.SpringWebBasic.DTO.EmployeeResponseNotFoundException;
import com.example.SpringWebBasic.DTO.ResponseDTO;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println("<-----Inside handleAllExceptions---->");
		CustomeResponse exceptionResponse = new CustomeResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EmployeeResponseNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(EmployeeResponseNotFoundException ex,
			WebRequest request) {
		System.out.println("<----Inside handleUserNotFoundException---->");
		CustomeResponse exceptionResponse = new CustomeResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("<----Inside handleMethodArgumentNotValid---->" + ex.getMessage());
		ResponseDTO responseDTO = new ResponseDTO();
		String message = "";
		Iterator itr = ex.getBindingResult().getAllErrors().iterator();
		while (itr.hasNext()) {
			message = message + "|" + ((DefaultMessageSourceResolvable)itr.next()).getDefaultMessage();
		}
		responseDTO.setMessage(message);
		responseDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());
		// CustomeResponse exceptionResponse = new CustomeResponse(new Date(),
		// "Validation Failed",
		// ex.getBindingResult().toString());
		return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
	}

}
