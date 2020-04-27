package com.org.sylvania.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_roles_user_mapping")
public class UserRoleMappingEntity {



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userRolesUserMappingId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_roles_id")
  private UserRolesEntity userRolesEntity;
}
