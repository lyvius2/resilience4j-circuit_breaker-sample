package com.walter.resilience4j.remote;

import com.walter.resilience4j.remote.dto.Sample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sample", url = "http://localhost:3000")
public interface SampleClient {

	@GetMapping("/users/{id}")
	Sample getUser(@PathVariable("id") String id);
}
