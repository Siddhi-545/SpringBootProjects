package com.siddhiself.springboot;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Notes 
 * Swagger2 is an open source project used to generate the REST API documents for RESTful web services. 
 * It provides a user interface to access our RESTful web services via the web browser.
 * 
 * @author Siddhi Diwane
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		HashSet<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.consumes(consumesAndProduces)
				.produces(consumesAndProduces)
				.pathMapping("/");
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Siddhi Swagger API")
				.description("Swagger API Description by Siddhi")
				.version("1.0")
				.contact(new Contact("Siddhi", "www.Google.com",
						"siddiwane545@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
	// Bean - Docket
	// Swagger 2
	// All the paths
	// All the apis

}
