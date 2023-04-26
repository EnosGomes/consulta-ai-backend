//package com.creta.consultaai.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Profile("dev")
//public class DevSecurityConfigurations {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .cors().and()
//                .authorizeHttpRequests(
//                        authorizeConfig -> {
//                            authorizeConfig.requestMatchers("/v1/api/*").permitAll();
//                            authorizeConfig.requestMatchers("/v1/api/**").permitAll();
////                            authorizeConfig.requestMatchers("/logout").permitAll();
////                            authorizeConfig.anyRequest().authenticated();
//
//                        })
//                //.oauth2Login(Customizer.withDefaults())
//                //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//
//
//
//}
//
//
