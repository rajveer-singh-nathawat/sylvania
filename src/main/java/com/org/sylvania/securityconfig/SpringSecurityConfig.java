package com.org.sylvania.securityconfig;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.org.sylvania.filter.JwtRequestFilter;
import com.org.sylvania.service.UserDetailService;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  @Value("${cross.origin.regex}")
  private String domainUrl;
  @Autowired
  private UserDetailService userDetailService;
  
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService);
}
  
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  
  @Bean
  public JwtRequestFilter jwtRequestFilterBean() {
      Properties properties = new Properties();
      properties.setProperty("crossOriginUrl", domainUrl);
      JwtRequestFilter authenticationFilter =
               new JwtRequestFilter(userDetailService, properties);
      return authenticationFilter;
  }
	
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
    .antMatchers("/authenticate", "/register", "/signin").permitAll()
    .and().formLogin().disable()

            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilterBefore(jwtRequestFilterBean(), UsernamePasswordAuthenticationFilter.class);
}


@Bean
public PasswordEncoder getPasswordEncoder() {

    return NoOpPasswordEncoder.getInstance();
}
	
}
