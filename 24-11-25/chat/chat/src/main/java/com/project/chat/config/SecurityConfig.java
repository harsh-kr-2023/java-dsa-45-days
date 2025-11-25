package com.project.chat.config;

import com.project.chat.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()     // Auth endpoints
                        .requestMatchers("/dashboard.html").permitAll()  // ← ADD THIS
                        .requestMatchers("/**.html").permitAll()         // ← ADD THIS (all HTML files)
                        .requestMatchers("/**.css").permitAll()          // ← ADD THIS (all CSS files)
                        .requestMatchers("/**.js").permitAll()           // ← ADD THIS (all JS files)
                        .requestMatchers("/ws/**").permitAll()           // ← ADD THIS (WebSocket)
                        .requestMatchers("/webjars/**").permitAll()      // ← ADD THIS (if using webjars)
                        .anyRequest().authenticated()  // Protect API endpoints only
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}