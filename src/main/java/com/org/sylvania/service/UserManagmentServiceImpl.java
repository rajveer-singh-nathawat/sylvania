package com.org.sylvania.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.sylvania.dto.ApiResponseDto;
import com.org.sylvania.dto.EditUserDto;
import com.org.sylvania.dto.UserDetailResponseDto;
import com.org.sylvania.entity.UserDataEntity;
import com.org.sylvania.entity.UserDetail;
import com.org.sylvania.entity.UserEntity;
import com.org.sylvania.repository.UserDataRepository;
import com.org.sylvania.repository.UserRepository;

@Service
public class UserManagmentServiceImpl implements UserManagmentService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserDataRepository userDataRepository;
  @Autowired
  private AuthorizeService authorizeService;

  @Override
  public ResponseEntity<?> getUser(Long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    UserDetailResponseDto userDetailResponseDto = new UserDetailResponseDto();
    userDetailResponseDto.setEmail(user.get().getEmail());
    userDetailResponseDto.setUserName(user.get().getUserName());

    userDetailResponseDto.setAddress(user.get().getUserDataEntity().getAddress());
    userDetailResponseDto.setDateOfBirth(user.get().getUserDataEntity().getDateOfBirth());
    userDetailResponseDto.setDesignation(user.get().getUserDataEntity().getDesignation());
    userDetailResponseDto.setFullName(user.get().getUserDataEntity().getFullName());
    userDetailResponseDto.setJobLocation(user.get().getUserDataEntity().getJobLocation());
    userDetailResponseDto.setJobStatus(user.get().getUserDataEntity().getJobStatus());
    userDetailResponseDto.setLivingStatus(user.get().getUserDataEntity().getLivingStatus());
    userDetailResponseDto.setPhoneNo(user.get().getUserDataEntity().getPhoneNo());
    userDetailResponseDto.setQualification(user.get().getUserDataEntity().getQualification());
    userDetailResponseDto.setCompanyName(user.get().getUserDataEntity().getCompanyName());

    return ResponseEntity.ok(userDetailResponseDto);
  }

  @Override
  public ResponseEntity<?> editUser(EditUserDto editUserDto) {
    UserDetail authUser = authorizeService.getAuthUser();
    Long id = authUser.getUserId();
    
    Optional<UserEntity> userEntity = userRepository.findById(id);
     
    userEntity.get().setUserId(id);
    userEntity.get().setUserName(editUserDto.getUserName());
    userRepository.save(userEntity.get());

    updateUserData(editUserDto, userEntity.get());
    return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto(true, "User updated Successfully"));
  }

  private void updateUserData(EditUserDto editUserDto, UserEntity userEntity) {
    
    Optional<UserDataEntity> userDataEntity = userDataRepository.findByUserId(userEntity.getUserId());
  
    userDataEntity.get().setAddress(editUserDto.getAddress());
    userDataEntity.get().setCompanyName(editUserDto.getCompanyName());
    userDataEntity.get().setDateOfBirth(editUserDto.getDateOfBirth());
    userDataEntity.get().setDesignation(editUserDto.getDesignation());
    userDataEntity.get().setFullName(editUserDto.getFullName());
    userDataEntity.get().setJobLocation(editUserDto.getJobLocation());
    userDataEntity.get().setJobStatus(editUserDto.getJobStatus());
    userDataEntity.get().setLivingStatus(editUserDto.getLivingStatus());
    userDataEntity.get().setPhoneNo(editUserDto.getPhoneNo());
    userDataEntity.get().setQualification(editUserDto.getQualification());
    userDataRepository.save(userDataEntity.get());
  }

 

}
