package com.evandro.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.model.Operator;
import com.evandro.service.OperatorService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	@Autowired
	private OperatorService userService;
	
	@RequestMapping(value="/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public LoginResponse autenthicate(@RequestBody Operator operator) throws ServletException{
		
		
		if (operator.getName() == null || operator.getPassword() == null){
			throw new ServletException("Name and password are required.");
		}
		
		//Query database
		Operator authenticatedOperator = userService.findByName(operator.getName());
		
		if(authenticatedOperator == null){
			throw new ServletException("User not found.");
		}
		
		if(!authenticatedOperator.getPassword().equals(operator.getPassword())){
			throw new ServletException("Wrong user or password.");
		}
		
		//{token: generatedcode}
		String token = Jwts.builder()
				.setSubject(authenticatedOperator
				.getName())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		return new LoginResponse(token);
	}
	
	private class LoginResponse{
		String token;
		
		public LoginResponse(String token){
			this.token = token;
		}
		
		public String getToken(){
			return token;
		}
	}
}
