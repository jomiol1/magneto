package com.magneto.constraint;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DnaConstraintValidator.class})
public @interface DnaConstraint {
	
	  String message() default "Los datos no corresponde a la secuencia de ADN";
	  Class<?>[] groups() default {};
	  Class<? extends Payload>[] payload() default {};

}
