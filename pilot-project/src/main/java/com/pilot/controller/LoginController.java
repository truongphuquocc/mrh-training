/**
 * 
 */
package com.pilot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PhuQuoc
 * @since 19 thg 4, 2023
 */
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {
  @GetMapping
  public String initPage() {
    return "tiles.login";
  }
  
  
}
