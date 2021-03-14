package com.walter.resilience4j.service;

import com.walter.resilience4j.remote.dto.Sample;

public interface SampleService {
	Sample getUser(String id);
}
