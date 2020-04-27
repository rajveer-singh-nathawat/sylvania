package com.org.sylvania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.dto.SigninDTO;
import com.org.sylvania.exception.IncorrectCredentialException;
import com.org.sylvania.service.LoginService;

@RestController
@RequestMapping
public class LoginController {
  @Autowired
  private LoginService loginService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateToken(@RequestBody SigninDTO signinDto) throws IncorrectCredentialException {
     ResponseEntity<?> createdToken= loginService.authenticateToken(signinDto);
return createdToken;
  }
}
