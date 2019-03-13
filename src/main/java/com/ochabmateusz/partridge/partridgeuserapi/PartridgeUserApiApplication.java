package com.ochabmateusz.partridge.partridgeuserapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PartridgeUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartridgeUserApiApplication.class, args);
	}

}
