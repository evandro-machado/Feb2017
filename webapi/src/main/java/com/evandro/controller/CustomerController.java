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

import com.evandro.model.Customer;
import com.evandro.service.CustomerService;

@RestController
@RequestMapping("/admin")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	//Endpoints
	@RequestMapping(method=RequestMethod.POST, value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		Customer registeredCustomer = customerService.register(customer);
		return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customers", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> findAllCustomers(){
		Collection<Customer> customersFound = customerService.findAll();
		return new ResponseEntity<>(customersFound, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customers/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id){
		Customer customer = customerService.findById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id){
		Customer customerFound = customerService.findById(id);
		if(customerFound == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customerService.delete(customerFound);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = customerService.update(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	
}
