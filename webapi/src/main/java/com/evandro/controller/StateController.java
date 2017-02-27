package com.evandro.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.State;
import com.evandro.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@RequestMapping(method=RequestMethod.POST, value="/states", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<State> registerState(@RequestBody State state){
		State registeredState = stateService.register(state);
		return new ResponseEntity<>(registeredState, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/states", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<State>> findAllStates(){
		Collection<State> statesFound = stateService.findAll();
		return new ResponseEntity<>(statesFound, HttpStatus.OK);
	}
	
	
}
