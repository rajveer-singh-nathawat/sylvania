package com.org.sylvania.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_roles")
public class UserRolesEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4801020656788508887L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_roles_id")
  private Long userRolesId;

  @Column(name = "roles")
  private String roles;

  // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY,
  // mappedBy = "userRolesEntity")
  // private List<UserRoleMappingEntity> userRoleMappingEntities =
  // new ArrayList<UserRoleMappingEntity>();


}
