package com.walter.resilience4j.controller;

import com.walter.resilience4j.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	private SampleService sampleService;

	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity getUser(@PathVariable("id") String id) {
		return ResponseEntity.ok(sampleService.getUser(id));
	}
}
