package com.org.sylvania.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPasswordValid {
	String message() default "Password not matched";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
