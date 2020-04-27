package com.org.sylvania.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.dto.EditUserDto;
import com.org.sylvania.entity.UserDetail;
import com.org.sylvania.service.AuthorizeService;
import com.org.sylvania.service.UserManagmentService;

@RestController
@RequestMapping()
public class UserManagmentController {

  @Autowired
  private UserManagmentService userManagmentService;
  @Autowired
  private AuthorizeService AuthorizeService;

  @PreAuthorize("@authorizeService.isAuthorized(T(com.org.sylvania.util.RolesData).ROLE)")
  @GetMapping("/view/user/{id}")
  public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
    ResponseEntity<?> user = userManagmentService.getUser(id);
    return user;
  }

  @PreAuthorize("@authorizeService.isAuthorized(T(com.org.sylvania.util.RolesData).ROLE)")
  @GetMapping("/view/profile")
  public ResponseEntity<?> getUser() {
    UserDetail authUser = AuthorizeService.getAuthUser();
    Long id = authUser.getUserId();
    ResponseEntity<?> user = userManagmentService.getUser(id);
    return user;
  }
  
  @PreAuthorize("@authorizeService.isAuthorized(T(com.org.sylvania.util.RolesData).ROLE)")
  @PutMapping("/edit/user")
  public ResponseEntity<?> editUser(@Valid @RequestBody EditUserDto editUserDto) {
    ResponseEntity<?> response = userManagmentService.editUser(editUserDto);
    return response;
    
    
  }


}
