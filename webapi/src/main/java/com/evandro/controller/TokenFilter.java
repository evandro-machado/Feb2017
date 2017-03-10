package com.evandro.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
			throw new ServletException("Token does not exist or token is invalid.");
		}
		
		String token = header.substring(7); //Extracting token value only (without "Bearer ").
		
		//Verify if token is valid
		try{
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		}catch(SignatureException e){
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Tokebn is invalid.");
			throw new ServletException("Invalid token.");
		}
		
		chain.doFilter(request, response);
		
	}

}
