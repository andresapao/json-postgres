package com.studies.jsonb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JsonbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonbApplication.class, args);
	}

}
