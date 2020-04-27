package com.org.sylvania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenInfo {

  private Long userId;
  private String userName;
  private String fullName;
  private String roles;
}
