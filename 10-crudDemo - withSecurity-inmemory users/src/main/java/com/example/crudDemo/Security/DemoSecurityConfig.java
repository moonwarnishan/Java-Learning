package com.example.crudDemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails nishan=  User.builder()
                .username("nishan")
                .password("{noop}test")
                .roles("EMP","ADMIN","MANAGER")
                .build();

        UserDetails mufi=  User.builder()
                .username("mufi")
                .password("{noop}test")
                .roles("EMP","MANAGER")
                .build();

        UserDetails jawad =  User.builder()
                .username("jawad")
                .password("{noop}test")
                .roles("EMP")
                .build();

        return new InMemoryUserDetailsManager(nishan,mufi,jawad);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMP")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("EMP")
                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")

        );
        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless Rest APIs that use POST, PUT, DELETE and/or PATCH
    http.csrf(csrf -> csrf.disable());
    return http.build();
    }
}
