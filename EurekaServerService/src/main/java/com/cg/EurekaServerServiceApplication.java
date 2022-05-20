package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//to put @SpringBootApplication to create a Spring Boot application
@SpringBootApplication
//The @EnableEurekaServer annotation is used to make your Spring Boot application acts as a Eureka Server.
@EnableEurekaServer
public class EurekaServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceApplication.class, args);
	}

}
