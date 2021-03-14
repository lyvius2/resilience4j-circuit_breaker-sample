package com.walter.resilience4j.service;

import com.walter.resilience4j.remote.SampleClient;
import com.walter.resilience4j.remote.dto.Sample;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	private final SampleClient sampleClient;

	public SampleServiceImpl(SampleClient sampleClient) {
		this.sampleClient = sampleClient;
	}

	@Override
	public Sample getUser(String id) {
		return sampleClient.getUser(id);
	}
}
