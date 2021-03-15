package com.walter.resilience4j.remote;

import com.walter.resilience4j.remote.dto.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleClientTest {

	@Autowired
	private SampleClient sampleClient;

	@Test
	void getUser() {
		Sample sample = sampleClient.getUser("1");
		assertThat(sample).isNotNull();
	}
}