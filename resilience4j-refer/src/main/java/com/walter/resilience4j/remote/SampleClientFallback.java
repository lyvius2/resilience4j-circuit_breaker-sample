package com.walter.resilience4j.remote;

import com.walter.resilience4j.remote.dto.Sample;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleClientFallback implements SampleClient {
	@Override
	public Sample getUser(String id) {
		log.error("{} user's data is null!!", id);
		return null;
	}
}
