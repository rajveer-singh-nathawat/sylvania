package com.org.sylvania.service;

import org.springframework.http.ResponseEntity;

public interface UserListService {

  

  ResponseEntity<?> getUserList(String livingStatus);

}
