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
public class OperatorController {

	@Autowired
	private OperatorService operatorService;
	
	@RequestMapping(method=RequestMethod.POST, value="/operators", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Operator> registerOperator(@RequestBody Operator operator){
		Operator registeredOperator = operatorService.registerOperator(operator);
		return new ResponseEntity<>(registeredOperator, HttpStatus.CREATED);
	}
	
}
