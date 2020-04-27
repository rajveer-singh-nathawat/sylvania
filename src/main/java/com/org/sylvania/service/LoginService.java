package com.org.sylvania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.org.sylvania.dto.AuthenticationResponse;
import com.org.sylvania.dto.SigninDTO;
import com.org.sylvania.exception.IncorrectCredentialException;
import com.org.sylvania.util.JwtUtil;

@Service
public class LoginService {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserDetailService userDetailService;
  @Autowired
  private JwtUtil jwtUtil;

  public ResponseEntity<?> authenticateToken(SigninDTO signinDto) throws IncorrectCredentialException {
try {
  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinDto.getUserNameOrEmail(), signinDto.getPassword()));
} catch (BadCredentialsException e) {
  throw new IncorrectCredentialException(e.getMessage());
}
final UserDetails userDetails = userDetailService.loadUserByUsername(signinDto.getUserNameOrEmail());
String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

}
