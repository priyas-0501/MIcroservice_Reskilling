package com.ibm.poc.controller;

import com.ibm.poc.dto.LoginDTO;
import com.ibm.poc.services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthenticationResource {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/authorize")
	public ResponseEntity<String> authenticate(@RequestBody LoginDTO requestData) {

		
		return userService.generateToken(requestData).map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		});
		
		
	}
}
