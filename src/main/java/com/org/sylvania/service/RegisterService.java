package com.org.sylvania.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.sylvania.dto.ApiResponseDto;
import com.org.sylvania.dto.UserDetailRequestDTO;
import com.org.sylvania.entity.UserDataEntity;
import com.org.sylvania.entity.UserEntity;
import com.org.sylvania.entity.UserRoleMappingEntity;
import com.org.sylvania.entity.UserRolesEntity;
import com.org.sylvania.repository.UserDataRepository;
import com.org.sylvania.repository.UserRepository;
import com.org.sylvania.repository.UserRoleMappingRepository;

@Service
@Transactional
public class RegisterService {
  @Autowired
  private UserDataRepository userDataRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserRoleMappingRepository userRoleMappingRepository;

  public ResponseEntity<?> signup(UserDetailRequestDTO userDetailJson) {
    saveUserSignupInfo(userDetailJson);

    return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto(true, "User Created Successfully"));

  }

  private void saveUserSignupInfo(UserDetailRequestDTO userDetailJson) {

    UserEntity userEntity = new UserEntity();
    userEntity.setUserName(userDetailJson.getUserName());
    userEntity.setEmail(userDetailJson.getEmail());
    userEntity.setPassword(userDetailJson.getPassword());
    userEntity.setActive(true);
    userRepository.save(userEntity);

    saveUserRolesUserMapping(userEntity);
    saveUserData(userDetailJson, userEntity);
 

  }

  private void saveUserData(UserDetailRequestDTO userDetailJson, UserEntity userEntity) {

    UserDataEntity userDataEntity = new UserDataEntity();
    userDataEntity.setFullName(userDetailJson.getFullName());
    userDataEntity.setAddress(userDetailJson.getAddress());
    userDataEntity.setDateOfBirth(userDetailJson.getDateOfBirth());
    userDataEntity.setDesignation(userDetailJson.getDesignation());
    userDataEntity.setAcceptStatus(-1);
    userDataEntity.setJobLocation(userDetailJson.getJobLocation());
    userDataEntity.setJobStatus(userDetailJson.getJobStatus());
    userDataEntity.setLivingStatus(userDetailJson.getLivingStatus());
    userDataEntity.setCompanyName(userDetailJson.getCompanyName());
    userDataEntity.setPhoneNo(userDetailJson.getPhoneNo());
    userDataEntity.setQualification(userDetailJson.getQualification());
    userDataEntity.setStatus(true);
    userDataEntity.setUserEntity(userEntity);

    userDataRepository.save(userDataEntity);
    
   
  }



  private void saveUserRolesUserMapping(UserEntity userEntity) {
    UserRoleMappingEntity userRoleMappingEntity = new UserRoleMappingEntity();

    UserRolesEntity userRolesEntity = new UserRolesEntity();
    userRolesEntity.setRoles("ROLE_USER");
    userRolesEntity.setUserRolesId(2L);
    userRoleMappingEntity.setUserEntity(userEntity);
    userRoleMappingEntity.setUserRolesEntity(userRolesEntity);
    userRoleMappingRepository.save(userRoleMappingEntity);

  }



}
