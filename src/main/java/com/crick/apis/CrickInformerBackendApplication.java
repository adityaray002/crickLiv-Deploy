package com.crick.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CrickInformerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickInformerBackendApplication.class, args);
	}

}
