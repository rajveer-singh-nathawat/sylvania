package com.org.sylvania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.DTO.AlumnusDTO;
import com.org.sylvania.DTO.SylvaniansDTO;
import com.org.sylvania.service.UserListService;

@RestController
@RequestMapping("/users")
public class UserListController {
	@Autowired
	private UserListService userListService;

	@GetMapping("/get-alumuns-list")
	public ResponseEntity<String> getAlumnsList(@RequestBody AlumnusDTO alumnusJson){
		userListService.getAlumnusList();
		return null;
	}
	@GetMapping("/get-sylvanians-list")
	public ResponseEntity<String> getSylvaniansList(@RequestBody SylvaniansDTO sylvaniansJson){
		userListService.getSylvaniansList();
		return null;
	}
}
