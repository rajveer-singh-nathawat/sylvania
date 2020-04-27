package com.org.sylvania.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.org.sylvania.entity.UserDetail;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@Service
public class AuthorizeService {

  private static final CharSequence TOKEN_PREFIX = "Bearer";
  private String SECRET_KEY = "secret";


  public Boolean isAuthorized(String[] userRole) {
    String role = fetchRoleInfo();
    if (role != null && role.equals(userRole[0]) || role.equals(userRole[1])) {
      return true;
    }
    return Boolean.FALSE;
  }

  private String fetchRoleInfo() {
    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
        .parseClaimsJws(getAuthUser().getJwt().replace(TOKEN_PREFIX, "")).getBody();
    String fetchedUser =claims.get("role").toString();
    return fetchedUser;
  }

  public UserDetail getAuthUser() {
    return (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
