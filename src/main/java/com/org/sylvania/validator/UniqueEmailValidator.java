package com.org.sylvania.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.sylvania.repository.UserAuthorityRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailValid, String>{

	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		return email != null && userAuthorityRepository.findByEmail(email) == null;
	}

}
