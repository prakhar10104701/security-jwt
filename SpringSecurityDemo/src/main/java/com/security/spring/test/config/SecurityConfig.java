package com.security.spring.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
   @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normalUser = User
                .withUsername("prakhar")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails adminUser = User
                .withUsername("srasti")
                .password(passwordEncoder().encode("12345"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);

        // Database Connection
        //Create CustomUserDetailService
        //return new CustomUserDetailService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests()
//                .requestMatchers("/home/admin")
//                .hasRole("ADMIN")
//                .requestMatchers("/home/normal")
//                .hasRole("NORMAL")
                .requestMatchers("/home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();

    }
}
