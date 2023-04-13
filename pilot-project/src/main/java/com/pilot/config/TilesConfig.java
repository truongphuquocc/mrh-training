package com.pilot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Configuration for Apache Tiles
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
@Configuration
public class TilesConfig {

  @Bean(name = "viewResolver")
  public ViewResolver getViewResolver() {

    UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

    // TilesView 3
    viewResolver.setViewClass(TilesView.class);
    viewResolver.setOrder(1);
    return viewResolver;
  }

  @Bean(name = "tilesConfigurer")
  public TilesConfigurer getTilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();

    // TilesView 3
    tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
    tilesConfigurer.setCompleteAutoload(true);
    return tilesConfigurer;
  }
}
