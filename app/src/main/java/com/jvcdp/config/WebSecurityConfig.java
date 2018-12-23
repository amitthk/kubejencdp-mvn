package com.jvcdp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
			"/webjars/**", 
			"/*.html", 
			"/favicon.ico", 
			"/**/*.css", 
			"/**/*.js",
			"/v2/api-docs/**", 
			"/swagger-resources/**",
            "/blogposts/**",
            "/home/**"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/**/*").denyAll();
    }

}