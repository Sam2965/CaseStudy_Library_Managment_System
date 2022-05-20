package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
////to put @SpringBootApplication to create a Spring Boot application
@SpringBootApplication
//The @EnableEurekaServer annotation is used to make your Spring Boot application acts as a Eureka Server.
@EnableEurekaClient
public class ApiGateWayForServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayForServiceApplication.class, args);
	}

}
