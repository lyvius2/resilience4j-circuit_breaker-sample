package com.walter.resilience4j.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;

public class SampleLoadbalancerConfig {
	@Bean
	public ServiceInstanceListSupplier sampleServiceInstanceListSupplier() {
		return new SampleServiceInstanceListSupplier("sample");
	}
}
