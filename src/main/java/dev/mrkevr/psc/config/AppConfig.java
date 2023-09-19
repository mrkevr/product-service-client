package dev.mrkevr.psc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

	private final String PRODUCT_API_BASE_URL = "http://localhost:8090";
	
	@Bean
	RestClient restClient() {
		return RestClient.builder()
			.baseUrl(PRODUCT_API_BASE_URL)
			.build();
	}
	
}
