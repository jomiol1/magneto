package com.magneto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.dto.MutantRequest;
import com.magneto.service.MutantService;

@RestController
@RequestMapping("/mutant")
public class MutantController {
	
	@Autowired
	private MutantService mutantService;
	
	
	 @PostMapping(
	            path = "/",
	            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isMutant(@RequestBody @Valid MutantRequest mutant) {
		 boolean check = mutantService.validate(mutant.getDna());
		return  ResponseEntity.status(check? HttpStatus.OK:HttpStatus.FORBIDDEN).body(check);
		
	}

}
