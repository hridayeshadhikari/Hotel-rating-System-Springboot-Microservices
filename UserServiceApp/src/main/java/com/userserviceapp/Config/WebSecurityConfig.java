package com.userserviceapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()

                .oauth2ResourceServer()
                .jwt();

        return security.build();
    }
}
