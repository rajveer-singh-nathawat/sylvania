package com.org.sylvania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.DTO.SigninDTO;
import com.org.sylvania.DTO.UserDetailRequestDTO;
import com.org.sylvania.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@PostMapping("/signin")
	public ResponseEntity<String> signin(@RequestBody SigninDTO signinDto) {
		
		return new ResponseEntity<String>(loginService.signin(signinDto),HttpStatus.OK);
		
	}
	@PostMapping("/signup")
	public ResponseEntity<HttpStatus> signup(@RequestBody UserDetailRequestDTO userDetailJson){
		HttpStatus status = loginService.signup(userDetailJson);
		return new ResponseEntity<>(status);
		
	}
	
	@GetMapping("/test")
	public String testMethod(){
		String status = "Hello World";
		return status;
		
	}
	
	
	

}
