package com.org.sylvania.DTO;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.org.sylvania.validator.ConfirmPasswordValid;
import com.org.sylvania.validator.UniqueEmailValid;
import com.org.sylvania.validator.UniquePhoneNo;
import com.org.sylvania.validator.UniqueUserName;

import lombok.Data;

@Data
@ConfirmPasswordValid
public class UserDetailRequestDTO {
	private Boolean status;
	@Pattern(regexp = "^[a-z0-9_-]{3,15}$")
	@UniqueUserName
	private String userName;
	@Email
	@UniqueEmailValid
	private String email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
	private String password;
	@Pattern(regexp = "^[A-Za-z\\.]${*25}")
	private String fullName;
	@Pattern(regexp = "\n" + "\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n"
			+ "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n"
			+ "4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$")
	@UniquePhoneNo
	private String phoneNo;
	@Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")
	private Date dateOfBirth;
	private String qualification;
	private String address;
	private String livingStatus;
	private String jobStatus;
	private String designation;
	private String jobLocation;
}
