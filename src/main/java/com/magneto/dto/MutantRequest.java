package com.magneto.dto;


import com.magneto.constraint.DnaConstraint;

import lombok.Data;

@Data
public class MutantRequest {
	
	@DnaConstraint
	private String[] dna;

}
