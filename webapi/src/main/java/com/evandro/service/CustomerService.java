package com.evandro.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evandro.model.Customer;
import com.evandro.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer register(Customer customer){
		return customerRepository.save(customer);
	}
	
	public Collection<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public void delete(Customer customer){
		customerRepository.delete(customer);
	}
	
	
	public Customer findById(Integer id) {
		return customerRepository.findOne(id);
	}
	
	public Customer update(Customer customer){
		return customerRepository.save(customer);
	}
}
