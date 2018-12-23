package com.jvcdp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(Predicates
	    		  .or(RequestHandlerSelectors.basePackage("com.jvcdp.controller"),
	    			RequestHandlerSelectors.basePackage("com.jvcdp.jvcdp.controller")))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("JVCDP REST API")
            .version("1.0")
            .license("jvcdp")
            .build();
    }
}
