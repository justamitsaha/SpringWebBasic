package com.example.SpringWebBasic.DTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeResponseNotFoundException extends RuntimeException {

	public EmployeeResponseNotFoundException(String exception) {
		super(exception);
	}
}
