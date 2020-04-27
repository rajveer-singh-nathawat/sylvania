package com.org.sylvania.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.sylvania.dto.SignupDTO;
import com.org.sylvania.entity.UserDetail;
import com.org.sylvania.repository.UserRepository;
@Service
public class UserDetailService implements UserDetailsService{

  @Autowired
  private UserRepository userRpository;
  
  @Override
  public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
    Optional<SignupDTO> signupDTO = userRpository.findbySignupInfo(userNameOrEmail);
    return signupDTO.map(UserDetail::new).get();
  }

}
