package com.evandro.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method=RequestMethod.GET, value="/states/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<State> findStateById(@PathVariable Integer id){
		State state = stateService.findById(id);
		return new ResponseEntity<>(state, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/states/{id}")
	public ResponseEntity<State> deleteState(@PathVariable Integer id){
		State stateFound = stateService.findById(id);
		
		if(stateFound == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		stateService.delete(stateFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/states", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<State> updateState(@RequestBody State state){
		State updatedState = stateService.update(state);
		return new ResponseEntity<>(updatedState, HttpStatus.OK);
	}
	
	
}
