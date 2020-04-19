package com.org.sylvania.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.org.sylvania.DTO.SigninDTO;
import com.org.sylvania.DTO.UserDetailRequestDTO;
import com.org.sylvania.entity.UserAuthorityEntity;
import com.org.sylvania.entity.UserDataEntity;
import com.org.sylvania.repository.UserDataRepository;

@Service
public class LoginService {
	@Autowired
	private UserDataRepository userDataRepository;

	public String signin(SigninDTO signinDto) {
		Optional<UserDataEntity> dataEntity=	userDataRepository.findByUserNameOrEmailAndPassword(signinDto.getUserNameOrEmail(),signinDto.getUserNameOrEmail(), signinDto.getPassword());
 
		if(dataEntity.isPresent()) {
			return dataEntity.get().getFullName();
		}
		return "login failed";
	}

	public HttpStatus signup(UserDetailRequestDTO userDetailJson) {
		saveSignupInfo(userDetailJson);
		saveUserAuthorityInfo(userDetailJson);
			
			return HttpStatus.CREATED;
		
	}

	private void saveUserAuthorityInfo(UserDetailRequestDTO userDetailJson) {
		UserAuthorityEntity authorityEntity =new UserAuthorityEntity();
		
		authorityEntity.setUserName(userDetailJson.getUserName());
		authorityEntity.setEmail(userDetailJson.getEmail());
		authorityEntity.setPassword(userDetailJson.getPassword());		
	}

	private void saveSignupInfo(UserDetailRequestDTO userDetailJson) {
		UserDataEntity signupUser = new UserDataEntity();
		
		signupUser.setFullName(userDetailJson.getFullName());
		signupUser.setAddress(userDetailJson.getAddress());
		signupUser.setDateOfBirth(userDetailJson.getDateOfBirth());
		signupUser.setDesignation(userDetailJson.getDesignation());
		signupUser.setJobLocation(userDetailJson.getJobLocation());
		signupUser.setJobStatus(userDetailJson.getJobStatus());
		signupUser.setLivingStatus(userDetailJson.getLivingStatus());
		signupUser.setPhoneNo(userDetailJson.getPhoneNo());
		signupUser.setQualification(userDetailJson.getQualification());		
	}

}
