package com.pilot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot Application
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
@SpringBootApplication
@PropertySource("classpath:config/datasource.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pilot")
@ComponentScan(basePackages = "com.pilot")
@EntityScan("com.pilot")
public class SpringBootWebApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }
}
