package com.org.sylvania.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailValid {
	String method() default "Allready exist.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

