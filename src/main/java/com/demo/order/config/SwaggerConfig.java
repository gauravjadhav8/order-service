package com.demo.order.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.OAS_30;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
	@Value("${project.swagger-host}")
	private String host;
	@Value("${project.name}")
	private String name;

	@Bean
	public Docket api() {
		return new Docket(OAS_30).apiInfo(new ApiInfoBuilder()
				.title(this.name).description("Order Service API documentation").build())
				.host(this.host).select().apis(basePackage("com.demo.order.controller")).build();
	}
}