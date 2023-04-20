//package com.pilot.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * This class is used to configure permission to access web application resources
// * 
// * @author PhuQuoc
// * @since 19 thg 4, 2023
// */
//@Configuration
//public class SecurityConfiguration {
//
//	@Bean
//	protected void configure(HttpSecurity http) throws Exception {
//
//		// User Permission 
//		http.authorizeRequests()
//				.antMatchers("/css/**", "/js/**", "/images/**","/plugins/**", "/*", "/**/*", "/**/**/*").permitAll()
//				.and() // Disable CRSF check
//						.csrf().disable();
//	}
//}