package com.walter.resilience4j.remote;

import com.walter.resilience4j.remote.dto.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleClientWrapper {
	private final SampleClient sampleClient;
	private final CircuitBreaker circuitBreaker;

	public SampleClientWrapper(SampleClient sampleClient, CircuitBreakerFactory circuitBreakerFactory) {
		this.sampleClient = sampleClient;
		this.circuitBreaker = circuitBreakerFactory.create("sample");
	}

	public Sample getUser(String id) {
		return circuitBreaker.run(() -> sampleClient.getUser(id), throwable -> getUserFallback(throwable));
	}

	private Sample getUserFallback(Throwable t) {
		log.error("user's data is null!! : {}", t.toString());
		return new Sample();
	}
}
