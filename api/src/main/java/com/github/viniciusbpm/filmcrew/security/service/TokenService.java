package com.github.viniciusbpm.filmcrew.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.viniciusbpm.filmcrew.domain.UserModel;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {
    public String generateToken(UserModel user) {
        String secret = System.getenv("JWT_SECRET");
        return JWT.create()
                .withIssuer("Movies")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(60)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String token){
        String secret = System.getenv("JWT_SECRET");
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("Movies")
                .build().verify(token).getSubject();
    }
}
