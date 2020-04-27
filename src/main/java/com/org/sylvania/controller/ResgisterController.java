package com.org.sylvania.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.dto.UserDetailRequestDTO;
import com.org.sylvania.service.RegisterService;

@RestController
@RequestMapping
public class ResgisterController {

  @Autowired
  private RegisterService registerService;

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@Valid @RequestBody UserDetailRequestDTO userDetailJson) {
    ResponseEntity<?> status = registerService.signup(userDetailJson);
    return status;
  }
}
