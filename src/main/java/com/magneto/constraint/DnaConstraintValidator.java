package com.magneto.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class DnaConstraintValidator implements ConstraintValidator<DnaConstraint,String[]>{
	
	@Override
	public boolean isValid(String[] value, ConstraintValidatorContext context) {
		String validStrings = "[ACGT]+";
		
		 for (int i = 0; i < value.length; i++) {
			if (!value[i].matches(validStrings)) {
				return false;
			}
		 }
		 return true;
	}

}
