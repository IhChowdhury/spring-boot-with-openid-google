package com.ibrahim.OpenID2Sample.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(a -> a
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated())
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .logout().logoutSuccessUrl("/").permitAll().and()
                .oauth2Login().successHandler((request, response, authentication) -> {
                    response.sendRedirect("/");
                });

        return http.build();
    }
}
