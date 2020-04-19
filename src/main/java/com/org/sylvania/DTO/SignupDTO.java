package com.org.sylvania.DTO;

import lombok.Data;

@Data
public class SignupDTO {
	private Boolean status;
	private Integer acceptStatus;
	private String userName;
	private String email;
	private String password;

}
