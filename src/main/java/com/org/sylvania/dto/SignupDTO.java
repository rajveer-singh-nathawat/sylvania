package com.org.sylvania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupDTO {
  private String userName;
  private String password;
  private Boolean active;
  private String roles;
  private Long userId;



}
