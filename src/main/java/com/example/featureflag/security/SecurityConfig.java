package com.example.featureflag.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//
//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.withUsername("user2")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                    try {
                        requests
                                .requestMatchers("/api/feature").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/api/admin").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                ;

        return http.build();
    }
}
