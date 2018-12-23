package com.jvcdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties
public class BlogpostApp extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(BlogpostApp.class, args);
    }

}
