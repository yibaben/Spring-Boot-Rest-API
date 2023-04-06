package com.yibaben.SpringBootRestAPI;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot RestFul Web Api Documentation",
				description = "Documentation for Spring Boot RestFul API",
				version = "V1.0",
				contact = @Contact(
						name = "Bennett",
						email = "yibaben@gmail.com",
						url = "https://www.yibaben.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.yibaben.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User management Documentation",
				url = "https://www.yibaben.com/user_management.html"
		)
)
public class SpringBootRestApiApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}

}
