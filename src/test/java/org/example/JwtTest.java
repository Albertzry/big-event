package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        //生成jwt
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }

    @Test
    public void testParse() {
        String Token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3NDA5MDM5NTN9" +
                ".D_oexBx-sj3cOZ0C0MCQ_sYZpp5VeniG4cFIwPlDkxo";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123456")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(Token);
        Map<String, Claim> clamis = decodedJWT.getClaims();
        System.out.println(clamis.get("user"));
    }
}