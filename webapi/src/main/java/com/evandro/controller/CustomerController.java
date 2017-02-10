package com.evandro.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.Customer;

@RestController
public class CustomerController {
	Map<Integer, Customer> customers;
	Integer nextId = 1;
	
	//Negócios
	private Customer register(Customer customer){
		if(customers == null){
			customers = new HashMap<>();
		}
		customer.setId(nextId);
		//Create id
		nextId++;
		
		customers.put(customer.getId(), customer);
		
		return customer;
	}
	
	private Collection<Customer> findAll(){
		return customers.values();
	}
	
	//Endpoints
	@RequestMapping(method=RequestMethod.POST, value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		Customer registeredCustomer = register(customer);
		return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customers", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> findAllCustomers(){
		Collection<Customer> customersFound = findAll();
		return new ResponseEntity<>(customersFound, HttpStatus.OK);
	}
}
