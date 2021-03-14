package com.walter.resilience4j.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class SampleServiceInstanceListSupplier implements ServiceInstanceListSupplier {

	private final String serviceId;

	public SampleServiceInstanceListSupplier(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 3000, false)));
	}
}
