package br.com.jose.addressapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket placeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.jose.addressapi"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		return  new ApiInfo(
				"Address Api", 
				"Api para cadastro de endereços.", 
				"1.0",
				"Terms Of Service",
				new Contact("Jose Vinicius", "", "jose.vinicius7@outlook.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/license.html", new ArrayList<>()
				);
		
	}
	
}
