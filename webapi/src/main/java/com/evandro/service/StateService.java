package com.evandro.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evandro.model.State;
import com.evandro.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository stateRepository;
	
	public State register(State state){
		return stateRepository.save(state);
	}
	
	public Collection<State> findAll(){
		return stateRepository.findAll();
	}
	
	public void delete(State state){
		stateRepository.delete(state);
	}
	
	public State findById(Integer id){
		return stateRepository.findOne(id);
	}
	
	public State update(State state){
		return stateRepository.save(state);
	}
	
}
