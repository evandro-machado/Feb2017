package com.evandro.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.Customer;

@RestController
public class CustomerController {
	Map<Integer, Customer> customers;
	Integer nextId = 1;
	
	//Business Rules
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
	
	private void delete(Customer customer){
		customers.remove(customer.getId());
	}
	
	
	private Customer findById(Integer id) {
		return customers.get(id);
	}
	
	private Customer update(Customer customer){
		customers.put(customer.getId(), customer);
		return customer;
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id){
		Customer customerFound = findById(id);
		if(customerFound == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		delete(customerFound);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = update(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	
}
