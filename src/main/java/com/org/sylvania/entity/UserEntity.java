package com.org.sylvania.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable{
	
  /**
   * 
   */
  private static final long serialVersionUID = -5446585315958087819L;

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	 
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "active")
	private boolean active;
	
	@OneToOne(mappedBy = "userEntity")
    private UserDataEntity userDataEntity;
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY,mappedBy = "userEntity" )
//	private List<UserRoleMappingEntity> userRoleMappingEntities = new ArrayList<UserRoleMappingEntity>();
//	


	

}
