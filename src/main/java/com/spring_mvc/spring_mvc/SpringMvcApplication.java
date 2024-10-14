package com.spring_mvc.spring_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

@SpringBootApplication
public class SpringMvcApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofSeconds(2L)).setConnectTimeout(Duration.ofSeconds(2L)).
		build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
