package com.walter.resilience4j.remote;

import com.walter.resilience4j.remote.dto.Sample;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleClientWrapper {

	private final SampleClient sampleClient;

	public SampleClientWrapper(SampleClient sampleClient) {
		this.sampleClient = sampleClient;
	}

	@CircuitBreaker(name = "sample", fallbackMethod = "getUserFallback")
	public Sample getUser(String id) {
		return sampleClient.getUser(id);
	}

	public Sample getUserFallback(Exception e) {
		log.error("user's data is null!! : {}", e.toString());
		return new Sample();
	}
}
