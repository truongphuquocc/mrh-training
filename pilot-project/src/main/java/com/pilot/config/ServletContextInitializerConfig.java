package com.pilot.config;

import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.pilot.common.constant.Constants;
import com.pilot.common.util.CommonUtil;

/**
 * Add configuration for application on start up
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
@Configuration
@ComponentScan(basePackages = "com.pilot")
public class ServletContextInitializerConfig implements ServletContextInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    System.setProperty(Constants.PROP_KEY_ROOT_FOLDER,
        CommonUtil.readProperties(Constants.PROP_KEY_ROOT_FOLDER, "config/application.properties"));
  }
}
