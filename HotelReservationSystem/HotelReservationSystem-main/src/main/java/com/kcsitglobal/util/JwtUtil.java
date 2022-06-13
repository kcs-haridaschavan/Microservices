package com.kcsitglobal.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author haridas.chavan
 *
 */
@Component
public class JwtUtil {

	@Value("${app.secret}")

	private String secret;

	/**
	 * 7. validate token user name and request user also expDate
	 * 
	 * @param token
	 * @param username
	 * @return
	 */
	public boolean validateToken(String token, String username) {
		String usernameInToken = getUsername(token);
		return (usernameInToken.equals(username) && !isTokenExpired(token));
	}

	/***
	 * 6. Check Current and Exp Date
	 * 
	 * @param token
	 * @return
	 */
	private boolean isTokenExpired(String token) {
		final Date expiration = getExpDate(token);
		return expiration.before(new Date());
	}

	/**
	 * 5. Generate Token with Empty Claims
	 * 
	 * @param username
	 * @return
	 */
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(claims, username);
	}

	/**
	 * 4.Read username
	 * 
	 * @param token
	 * @return
	 */
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	/**
	 * 3. read ExpDate
	 * 
	 * @param token
	 * @return
	 */
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

	/**
	 * 2. Read Claim
	 * 
	 * @param token
	 * @return
	 */
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 *
	 * 1. generate token
	 * 
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String generateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuer("HARI")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}
