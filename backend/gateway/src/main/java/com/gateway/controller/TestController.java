package com.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gateway.exception.ApiException;

@RestController
@RequestMapping("/api/gateway")
public class TestController {
	
	@GetMapping("/testException")
	public ResponseEntity<String> testException() {
	    throw new ApiException("Testing exception handling", HttpStatus.BAD_REQUEST);
	}
}
