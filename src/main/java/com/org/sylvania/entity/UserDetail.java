package com.org.sylvania.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.org.sylvania.dto.SignupDTO;

public class UserDetail implements UserDetails {
  /**
   * 
   */
  private static final long serialVersionUID = -7173790367300363774L;
  
  private String userName;
  private String password;
  private Boolean active;
  private List<GrantedAuthority> authorities;
  private Long userId;
  private String jwt;

  public UserDetail(SignupDTO signupDTO) {
    this.userName = signupDTO.getUserName();
    this.password = signupDTO.getPassword();
    this.active = signupDTO.getActive();
    this.authorities = Arrays.stream(signupDTO.getRoles().split(","))
        .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    this.userId = signupDTO.getUserId();
  }

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }

  public Long getUserId() {
    return userId;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return active;
  }

}
