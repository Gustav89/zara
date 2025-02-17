package com.capitole.zara.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(c -> {
                    c.ignoringRequestMatchers("/api/v1/prices");
                    c.ignoringRequestMatchers("/api/v1/prices/*");
                });

        return httpSecurity.build();
    }

}
