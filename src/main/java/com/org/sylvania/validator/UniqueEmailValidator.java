package com.org.sylvania.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.sylvania.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailValid, String>{

	@Autowired
	private UserRepository userRepository;
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		return email != null && userRepository.findByEmail(email) == null;
	}

}
