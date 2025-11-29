package com.chatflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Secret key for JWT - same as in application.properties
    private final String JWT_SECRET = "mySuperSecretKeyThatIsAtLeast256BitsLongForJWTEncoding123!";

    /**
     * Password encoder bean - used to hash passwords before storing in database
     * BCrypt is the industry standard for password hashing
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * JWT Decoder - used to validate and decode JWT tokens
     * Spring Security will automatically use this to validate tokens
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        // Convert our secret string to a SecretKey object
        SecretKey secretKey = new SecretKeySpec(JWT_SECRET.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

    /**
     * Main security configuration
     * This defines what endpoints are public vs protected
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for APIs (we're using JWT tokens)
                .csrf(csrf -> csrf.disable())

                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints - no authentication required
                        .requestMatchers("/api/auth/**").permitAll()  // Auth endpoints
                        .requestMatchers("/ws/**").permitAll()        // WebSocket handshake
                        .requestMatchers("/**.html", "/**.css", "/**.js").permitAll() // Static files

                        // All other endpoints require authentication
                        .anyRequest().authenticated()
                )

                // Configure OAuth2 Resource Server for JWT
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.decoder(jwtDecoder())) // Use our JWT decoder
                )

                // Stateless session management (we're using JWT, not sessions)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}