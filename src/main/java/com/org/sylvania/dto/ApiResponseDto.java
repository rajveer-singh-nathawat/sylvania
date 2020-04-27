package com.org.sylvania.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto {

  private Boolean status;
  private String message;
}
