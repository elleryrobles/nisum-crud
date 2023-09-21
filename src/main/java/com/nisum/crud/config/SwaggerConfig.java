package com.nisum.crud.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());  // api own information
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot Example Swagger",
                "Here some description of API.",
                "API 1.0",
                "Terms of service",
                new Contact("My name", "www.mydomain.com", "myeaddress@mydomain.com"),
                "License of API", "API license URL",
                Collections.emptyList());
    }
}