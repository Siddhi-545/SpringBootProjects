package com.siddhiself.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * this class launches a Spring application from a Java main method
 * @author Siddhi Diwane
 * @SpringBootApplication annotation can be used to enable those three features, that is
 * @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 * @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
 * @Configuration: allow to register extra beans in the context or import additional configuration classes
 * Username : Siddhi Password = secret123
 */

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RestWebServicesHelloworldbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServicesHelloworldbeanApplication.class, args);
	}
}
