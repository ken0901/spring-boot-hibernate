package com.ken.app.test.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HomeSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("EMPLOYEE")
                .build();

        UserDetails katie = User.builder()
                .username("katie")
                .password("{noop}katie123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails ken = User.builder()
                .username("ken")
                .password("{noop}ken123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,katie,ken);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
                    configure
                            .requestMatchers("/").hasRole("EMPLOYEE")
                            .requestMatchers("/leaders/**").hasRole("MANAGER")
                            .requestMatchers("/systems/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
                )
                .formLogin(form ->
                    form
                            .loginPage("/showLoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );
        return http.build();
    }
}
