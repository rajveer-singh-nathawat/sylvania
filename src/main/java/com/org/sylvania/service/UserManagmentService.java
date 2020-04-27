package com.org.sylvania.service;

import org.springframework.http.ResponseEntity;

import com.org.sylvania.dto.EditUserDto;

public interface UserManagmentService {

  ResponseEntity<?> getUser(Long id);

  ResponseEntity<?> editUser(EditUserDto editUserDto);

}
