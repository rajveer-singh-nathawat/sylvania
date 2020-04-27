package com.org.sylvania.filter;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.org.sylvania.entity.UserDetail;
import com.org.sylvania.service.UserDetailService;
import com.org.sylvania.util.JwtUtil;


public class JwtRequestFilter extends OncePerRequestFilter {

  private UserDetailService userDetailService;

  @Autowired
  private JwtUtil jwtUtil;

  private String domainUrl;

  public JwtRequestFilter(UserDetailService userDetailService, Properties properties) {
    domainUrl = properties.getProperty("crossOriginUrl");
    this.userDetailService = userDetailService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authorizationHeader = httpRequest.getHeader("X-Authorization");

    HttpServletResponse res = (HttpServletResponse) response;
    res.setHeader("Access-Control-Allow-Origin", domainUrl);
    res.setHeader("Access-Control-Allow-Credentials", "true");
    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PATCH ,PUT");
    res.setHeader("Access-Control-Max-Age", "3600");
    res.setHeader("Access-Control-Allow-Headers", "X-Authorization, Content-Type, Accept");

    String username = null;
    String token = null;
    if (!httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
      if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        token = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(token);
      }

      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetail userDetail = (UserDetail) this.userDetailService.loadUserByUsername(username);
        userDetail.setJwt(token);
        if (jwtUtil.validateToken(token, userDetail)) {
          UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(userDetail, null,
                  userDetail.getAuthorities());
          usernamePasswordAuthenticationToken
              .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

      }
      filterChain.doFilter(request, res);
    } else {
      res.setStatus(HttpServletResponse.SC_OK);
    }


  }

}
