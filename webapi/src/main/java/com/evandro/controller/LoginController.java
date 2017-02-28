package com.evandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.User;

@RestController
public class LoginController {
	
	@Autowired
	
	@RequestMapping(value="/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public void autenthicate(@RequestBody User user){
		System.out.println("Called method authenticate " + user.getName() + " " + user.getPassword());
		
		//Query database
	}
}
