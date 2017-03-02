package com.evandro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evandro.model.Operator;
import com.evandro.repository.OperatorRepository;

@Service
public class OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	public Operator registerOperator(Operator operator){
		return operatorRepository.save(operator);
	}
	
	public Operator findByName(String name){
		return operatorRepository.findByName(name);
	}
	
}
