package com.magneto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsResponse {
	
	@JsonProperty("count_mutant_dna")
	private Long countMutantDna;
	
	@JsonProperty("count_human_dna")
	private Long countHumanDna;
	
	private double ratio;

}
