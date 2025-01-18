package com.Assigment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Define a PasswordEncoder bean to use BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define a SecurityFilterChain bean to disable security for all routes
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/", "/login", "/register", "/admission-form", "/submit-admission")  // Allow public access to these pages
                .permitAll()
                .anyRequest().authenticated()  // Protect the rest of the routes
            .and()
            .formLogin()
                .loginPage("/login")  // Use custom login page
                .permitAll()
            .and()
            .logout()
                .permitAll();  // Allow public access to logout
        return http.build();
    }
}
