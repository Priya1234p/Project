package com.authserviceex1.service;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JwtService {
	private static final String SECRET_KEY = "tdUrx91Th/P55EWlUj08RayOtHUgp2K5gw8YwjIdp2Q=";
    private static final long EXPIRATION_TIME = 86400000; // 1 day
    
    public String generateToken(String username) {
        return JWT.create()
            .withSubject(username)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC256(SECRET_KEY));
    }
    
    public String validateTokenAndRetrieveSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY))
            .build()
            .verify(token)
            .getSubject();
    }

}
