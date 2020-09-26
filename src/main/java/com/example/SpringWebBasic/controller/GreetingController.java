package com.example.SpringWebBasic.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringWebBasic.DTO.EmployeeRequest;
import com.example.SpringWebBasic.DTO.EmployeeResponse;
import com.example.SpringWebBasic.DTO.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/* Basis Get */
	@GetMapping("/getGreetings")
	public Greeting greetingGet(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/*
	 * Just a basic post no validation even if you pass a blank JSON it will return
	 */ 
	@PostMapping("/postGreetings")
	public Greeting greetingsPost(@RequestBody Greeting greetings) {
		Greeting gt = new Greeting(greetings.getId() * 2, "HELLO " + greetings.getContent());
		return gt;
	}
	
	/* Using Response Entity to send formatted response */
	@PostMapping("/formattedGreetings")
	public ResponseEntity<EmployeeResponse> formattedGreetings(@RequestBody Greeting greeting) {

		HttpHeaders responseHeaders = new HttpHeaders();
		EmployeeResponse emp = new EmployeeResponse();
		emp.setId("65487");
		emp.setfName("Lauru");
		emp.setDepartment("Jhat");
		emp.setlName("Bal");
		emp.setAddress("Thapai Khana");
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(emp);
	}

	@PostMapping("/validateRequst")
	public ResponseEntity<Greeting> validateRequst(@Valid @RequestBody EmployeeRequest empReq) {
		System.out.println("<----- Inside validate request----->");
		Greeting gt = new Greeting(6, "HELLO LENDU");
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(gt);
	}
}