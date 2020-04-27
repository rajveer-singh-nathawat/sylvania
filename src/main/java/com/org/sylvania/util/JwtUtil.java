package com.org.sylvania.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.org.sylvania.dto.TokenInfo;
import com.org.sylvania.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {


  @Autowired
  private UserRepository userRepository;
  private String SECRET_KEY = "secret";
  public static final long JWT_TOKEN_VALIDITY = 15 * 60 * 60;

  public String extractUsername(String token) {
      return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
      return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllClaims(token);
      return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
      return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  private Boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
      TokenInfo tokenInfo = userRepository.findTokenInfo(userDetails.getUsername());
      Map<String, Object> claims = new HashMap<>();
      claims.put("userId", tokenInfo.getUserId());
      claims.put("userName", tokenInfo.getUserName());
      claims.put("fullName", tokenInfo.getFullName());
      claims.put("role", tokenInfo.getRoles());
      
      return createToken(claims);
  }

  private String createToken(Map<String, Object> claims) {
    final long now = System.currentTimeMillis();
      return Jwts.builder().setClaims(claims).setSubject(claims.get("userName").toString()).setIssuedAt(new Date(now))
              .setExpiration(new Date(now + JWT_TOKEN_VALIDITY * 10000))
              .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }
  
  public Boolean validateToken(String token, UserDetails userDetails) {
      final String username = extractUsername(token);
      return (!isTokenExpired(token) && username.equals(userDetails.getUsername()));
  }

}
