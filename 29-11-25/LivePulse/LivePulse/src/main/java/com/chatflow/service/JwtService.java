package com.chatflow.service;

import com.chatflow.model.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;
    private final String JWT_SECRET = "mySuperSecretKeyThatIsAtLeast256BitsLongForJWTEncoding123!";

    public JwtService() {
        // Create JWT encoder with our secret key
        SecretKey secretKey = new SecretKeySpec(JWT_SECRET.getBytes(), "HmacSHA256");

        // FIX: Use ImmutableSecretJWK instead of directly passing SecretKey
        this.jwtEncoder = new NimbusJwtEncoder((jwkSelector, context) -> {
            try {
                // Create a JWK from our secret key
                com.nimbusds.jose.jwk.source.JWKSource securityContext = null;
                com.nimbusds.jose.jwk.OctetSequenceKey jwk = new com.nimbusds.jose.jwk.OctetSequenceKey.Builder(secretKey)
                        .keyID("chatflow-key")
                        .build();
                return jwkSelector.select(new com.nimbusds.jose.jwk.JWKSet(jwk));
            } catch (Exception e) {
                throw new RuntimeException("Failed to create JWK source", e);
            }
        });
    }

    /**
     * Generate JWT token for a user
     */
    public String generateToken(User user) {
        Instant now = Instant.now();
        Instant expiry = now.plus(24, ChronoUnit.HOURS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("chatflow-app")
                .issuedAt(now)
                .expiresAt(expiry)
                .subject(user.getUsername())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}