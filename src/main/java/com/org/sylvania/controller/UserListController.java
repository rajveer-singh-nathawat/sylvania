package com.org.sylvania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sylvania.dto.AlumnusDTO;
import com.org.sylvania.dto.SylvaniansDTO;
import com.org.sylvania.service.UserListService;

@RestController
@RequestMapping()
public class UserListController {
  @Autowired
  private UserListService userListService;

  @PreAuthorize("@authorizeService.isAuthorized(T(com.org.sylvania.util.RolesData).ROLE)")
  @GetMapping("/get-alumuns-list")
  public ResponseEntity<?> getAlumnusList() {
    String livingStatus = "Alumnus";
    ResponseEntity<?> alumnusList = userListService.getUserList(livingStatus);
    return alumnusList;
  }

  @PreAuthorize("@authorizeService.isAuthorized(T(com.org.sylvania.util.RolesData).ROLE)")
  @GetMapping("/get-sylvanians-list")
  public ResponseEntity<?> getSylvaniansList() {
    String livingStatus = "Sylvanian";
    ResponseEntity<?> sylvanianList = userListService.getUserList(livingStatus);
    return sylvanianList;
  }
}
