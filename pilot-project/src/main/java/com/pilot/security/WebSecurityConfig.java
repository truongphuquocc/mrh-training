package com.pilot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class is used to configure permission to access web application resources
 * 
 * @author PhuQuoc
 * @since 19 thg 4, 2023
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(value = 101)
public class WebSecurityConfig {

  // Injecting JWT custom authentication provider
  @Autowired
  private CustomAuthenticationProvider authProvider;

  @Bean
  AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  // adding our custom authentication providers
  // authentication manager will call these custom provider's
  // authenticate methods from now on.
  @Autowired
  void registerProvider(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(authProvider);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        .antMatchers("/","/css/**", "/js/**","/styles/**","/scripts/**", "/images/**","/plugins/**","/login").permitAll()
        .antMatchers("/brand", "/product").access("hasRole('ROLE_ADMIN')").anyRequest()
        .authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/loginAction")
        .defaultSuccessUrl("/product").usernameParameter("username").passwordParameter("password")
        .failureUrl("/login?error").and().logout().logoutSuccessUrl("/login").and()
        .exceptionHandling().accessDeniedPage("/login");

    return http.build();
  }
}
