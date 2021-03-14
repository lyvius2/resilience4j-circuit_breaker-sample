package com.walter.resilience4j.remote;

import com.walter.resilience4j.config.SampleLoadbalancerConfig;
import com.walter.resilience4j.remote.dto.Sample;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@LoadBalancerClient(name = "sample", configuration = SampleLoadbalancerConfig.class)
@FeignClient(name = "sample")
public interface SampleClient {

	@GetMapping("/users/{id}")
	Sample getUser(@PathVariable("id") String id);
}
