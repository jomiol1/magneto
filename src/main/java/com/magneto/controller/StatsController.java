package com.magneto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.dto.StatsResponse;
import com.magneto.service.MutantService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private MutantService mutantService;
	
	
	 @GetMapping(
	            path = "/",
	            produces = MediaType.APPLICATION_JSON_VALUE)
	public StatsResponse getStats() {
		return mutantService.stats();
		}

}
