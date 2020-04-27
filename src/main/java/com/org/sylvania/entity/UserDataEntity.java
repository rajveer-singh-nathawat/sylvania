package com.org.sylvania.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User_Data")
@Data
public class UserDataEntity implements Serializable{
	/**
   * 
   */
  private static final long serialVersionUID = 2131717738655145292L;


  @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_data_id")
	private Long userDataId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "user_id", name = "user_id")
    private UserEntity userEntity;
	
	@Column(name="status")
	private Boolean status ;
	
	@Column(name="accept_status")
	private Integer acceptStatus;
	
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
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="job_location")
	private String jobLocation;
	
	
	

}
