package com.org.sylvania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.sylvania.dto.UserListDto;
import com.org.sylvania.repository.UserRepository;
@Service
public class UserListServiceImpl implements UserListService{

  @Autowired
  private UserRepository userRepository;
  

  @Override
  public ResponseEntity<?> getUserList(String livingStatus) {
  List<UserListDto> userList = userRepository.findAllUserList(livingStatus);
  
    return ResponseEntity.ok(userList);
  }

}
