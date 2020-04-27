package com.org.sylvania.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.org.sylvania.validator.UniqueEmailValid;
import com.org.sylvania.validator.UniquePhoneNo;
import com.org.sylvania.validator.UniqueUserName;

import lombok.Data;

@Data

public class UserDetailRequestDTO {
//	private Boolean status;
	@NotNull(message = "User name can not be null.")
	@Pattern(regexp = "^[A-Za-z]{4,8}[0-9]{2}$")
	@UniqueUserName
	private String userName;
	@Email
	@UniqueEmailValid
	@NotNull(message = "Email can not be null.")
	private String email;
	@NotNull(message = "Password cannot be null.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
	@NotNull(message = "Full name can not be null.")
	@Pattern(regexp = "^[A-Za-z\\s]{0,25}$")
	private String fullName;
	@NotNull(message = "Phone no can not be null.")
	@Pattern(regexp = "^[0-9]*$")
	@UniquePhoneNo
	private String phoneNo;
	private Date dateOfBirth;
	@NotNull(message = "qualification can not be null.")
	private String qualification;
	@NotNull(message = "address can not be null.")
	private String address;
	private String livingStatus;
	private String jobStatus;
	@NotNull(message = "Company Name can not be null.")
	private String companyName;
	@NotNull(message = "designation can not be null.")
	private String designation;
	@NotNull(message = "jobLocation can not be null.")
	private String jobLocation;
}
