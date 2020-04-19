package com.org.sylvania.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User_Data")
@Data
public class UserDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="status")
	private Boolean status = true;
	
	@Column(name="accept_status")
	private Integer acceptStatus=-1;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="dob")
	private Date dateOfBirth;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="address")
	private String address;
	
	@Column(name="living_status")
	private String livingStatus;
	
	@Column(name="job_status")
	private String jobStatus;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="job_location")
	private String jobLocation;
	
	
	

}
