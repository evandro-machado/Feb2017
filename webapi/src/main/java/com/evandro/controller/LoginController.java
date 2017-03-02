package com.evandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.Operator;
import com.evandro.service.OperatorService;

@RestController
public class LoginController {
	
	@Autowired
	private OperatorService userService;
	
	@RequestMapping(value="/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public ResponseEntity<Operator> autenthicate(@RequestBody Operator operator){
		System.out.println("Called method authenticate " + operator.getName() + " " + operator.getPassword());
		
		//Query database
		Operator authenticatedOperator = userService.findByName(operator.getName());
		
		return new ResponseEntity<Operator>(authenticatedOperator, HttpStatus.OK);
	}
}
