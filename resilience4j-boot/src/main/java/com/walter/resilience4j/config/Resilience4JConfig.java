package com.walter.resilience4j.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED;

@Configuration
public class Resilience4JConfig {

	@Bean
	public CircuitBreakerFactory circuitBreakerFactory() {
		final CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.minimumNumberOfCalls(4)
				.failureRateThreshold(50)
				.slidingWindowType(COUNT_BASED)
				.build();

		final CircuitBreakerFactory factory = new Resilience4JCircuitBreakerFactory();
		factory.configureDefault(new Function<String, Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration>() {
			@Override
			public Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration apply(String s) {
				return new Resilience4JConfigBuilder(s).circuitBreakerConfig(circuitBreakerConfig).build();
			}
		});
		return factory;
	}
}
