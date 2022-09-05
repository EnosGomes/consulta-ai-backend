package com.creta.consultaai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
	

    //configura autenticação 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            .antMatchers("/api/v1").permitAll()
            .antMatchers("/api/v1/**").permitAll()
            .antMatchers("/api/v1/hospitais/*").permitAll()
            .antMatchers("/hospitais").permitAll()
            .antMatchers("/api/v1/consultas/*").permitAll()
            .antMatchers("/consultas").permitAll()
            .antMatchers("/auth").permitAll()
            .and().cors()
            .and().csrf().disable();    
        
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedOrigins("http://localhost:8080/h2-console/**")
            .allowedOrigins("http://localhost:8080/h2-console/*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

}
