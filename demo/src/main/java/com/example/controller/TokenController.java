package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.LoginRequest;
import com.example.jwt.LoginResponse;
import com.example.service.TokenService;

@RestController
public class TokenController {
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/getToken")
	public ResponseEntity<LoginResponse> getToken(@RequestBody LoginRequest request){
		
		LoginResponse res = tokenService.createToken(request);
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/parseToken")
	public Map<String, Object> parseToken(@RequestBody String token){
		return tokenService.parseToken(token);
	}
}
