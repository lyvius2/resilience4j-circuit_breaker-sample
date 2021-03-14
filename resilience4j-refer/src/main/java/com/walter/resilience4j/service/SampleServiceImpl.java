package com.walter.resilience4j.service;

import com.walter.resilience4j.remote.SampleClientWrapper;
import com.walter.resilience4j.remote.dto.Sample;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	private final SampleClientWrapper sampleClientWrapper;

	public SampleServiceImpl(SampleClientWrapper sampleClientWrapper) {
		this.sampleClientWrapper = sampleClientWrapper;
	}

	@Override
	public Sample getUser(String id) {
		return sampleClientWrapper.getUser(id);
	}
}
