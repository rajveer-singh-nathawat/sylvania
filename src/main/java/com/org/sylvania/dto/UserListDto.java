package com.org.sylvania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {

  private Long userId;
  private String fullName;
  private String designation;
}
