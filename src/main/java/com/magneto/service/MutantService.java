package com.magneto.service;

import com.magneto.dto.StatsResponse;

public interface MutantService {
	
	public boolean check(String[] dna);
	
	public boolean validate(String[] dna);
	
	public StatsResponse stats();

}
