package com.example.service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.jwt.LoginRequest;
import com.example.jwt.LoginRequest;
import com.example.jwt.LoginResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class TokenService {
    private Key secretKey;
    private JwtParser jwtParser;
    @PostConstruct
    private void init() {
        String key = "VincentIsRunningBlogForProgrammingLearner";
        secretKey = Keys.hmacShaKeyFor(key.getBytes());
        jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
        
    }

    public LoginResponse createToken(LoginRequest request) {
        String accessToken = createAccessToken(request.getUserId());
        String accessToken2 = createAccessToken(request.getUserName());

        LoginResponse res = new LoginResponse();
        res.setAccessToken(accessToken);
        

        return res;
    }

    private String createAccessToken(String username) {
        // 有效時間（毫秒）
        long expirationMillis = Instant.now()
                .plusSeconds(90)
                .getEpochSecond()
                * 1000;

        // 設置標準內容與自定義內容
        Claims claims = Jwts.claims();
        claims.setSubject("Access Token");
        claims.setIssuedAt(new Date());
        claims.setExpiration(new Date(expirationMillis));
        claims.put("username", username);

        // 簽名後產生 token
        return Jwts.builder()
                .setClaims(claims)
                .signWith(secretKey)
                .compact();
    }
    
    public Map<String, Object> parseToken(String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        return new HashMap<>(claims);
    }
}
    
    


