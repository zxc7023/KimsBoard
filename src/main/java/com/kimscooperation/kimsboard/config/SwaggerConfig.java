package com.kimscooperation.kimsboard.config;

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
	private String title;
	private String version;
	
	@Bean
	public Docket apiVersion1() {
		
		version = "v1";
		title = "kimsboard API Document " + version; 
		
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.groupName(version)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kimscooperation.kimsboard.controller.v1"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo(title, version));
	}
	
	

	private ApiInfo apiInfo(String title, String version) {
		return new ApiInfo(title, "Frontend와의 협업을 위해 작성", version, "termsOfServiceUrl",
				new Contact("JunkiKim", "https://github.com/zxc7023/kimsboard", "zxc7023@gmail.com"), null, null);
	}

}