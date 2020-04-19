package com.org.sylvania.DTO;

import java.util.Date;

import lombok.Data;
@Data
public class UserDataDTO {
	private String fullName;
	private String phoneNo;
	private Date dateOfBirth;
	private String qualification;
	private String address;
	private String livingStatus;
	private String jobStatus;
	private String designation;
	private String jobLocation;
}
