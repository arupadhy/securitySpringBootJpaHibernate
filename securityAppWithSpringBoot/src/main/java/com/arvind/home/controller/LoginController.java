package com.arvind.home.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value="/customLogin",method=RequestMethod.GET)
	public ResponseEntity<Object> login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
