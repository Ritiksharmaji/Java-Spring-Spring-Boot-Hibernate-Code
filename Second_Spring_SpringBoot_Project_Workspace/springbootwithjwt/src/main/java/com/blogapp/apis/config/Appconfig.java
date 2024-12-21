package com.blogapp.apis.config;

import java.security.Principal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class Appconfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//    	/*
//    	 * here User is inbulid spring user not user-defined,
//    	 *  we are create create user and setting there name and password we can create more than one user also
//    	 */
//        UserDetails userDetails =  User.builder().username("ritik")
//                .password(passwordEncoder().encode("ritik123")).roles("user").build();
//        
//        UserDetails userDetails2 =  User.builder().username("ankit")
//                .password(passwordEncoder().encode("ankit123")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(userDetails,userDetails2);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
    
    
    
    
}