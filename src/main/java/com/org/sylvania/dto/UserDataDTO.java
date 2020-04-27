package com.org.sylvania.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {
  
  private String fullName;
  private String phoneNo;
  private Date dateOfBirth;
  private String qualification;
  private String address;
  private String livingStatus;
  private String jobStatus;
  private String companyName;
  private String designation;
  private String jobLocation;

}
