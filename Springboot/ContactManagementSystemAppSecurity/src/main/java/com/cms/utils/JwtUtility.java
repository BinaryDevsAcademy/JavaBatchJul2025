package com.cms.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtility {
	
	@Value("${jwt.secret}")
	private String key;
	
	private SecretKey skey;
	private Map<String, Object> claimsMap = new HashMap<>();
	private Date issuedDate = new Date(System.currentTimeMillis());
	private Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * (60 * 2));
	
	@PostConstruct
	public void init() {
		//converting our secret key string to secretkeyObject
		this.skey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
	}
	
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.issuedAt(issuedDate)
				.expiration(expirationDate)
				.claims(claimsMap)
				.signWith(skey)
				.compact();
	}

	public String extractUsername(String token) {
		Claims claim = extractToken(token);
		return claim.getSubject();
	}
	
	public Claims extractToken(String token) {
		Claims claims =  Jwts.parser()
						.verifyWith(skey)
						.build()
						.parseSignedClaims(token)
						.getPayload();
		return claims;
		
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		Claims claims = extractToken(token);
		boolean isUsernameMatched = claims.getSubject().equals(userDetails.getUsername());
		return isUsernameMatched && !isTokenExpired(token);
	}
	
	public boolean isTokenExpired(String token) {
		Claims claims = extractToken(token);
		Date currentTime = new Date(System.currentTimeMillis());
		
		return currentTime.after(claims.getExpiration());
	}
	
		
}
