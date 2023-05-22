/**
 * 
 */
package com.pilot.user.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.ProductService;

/**
 * @author PhuQuoc
 * @since 27 thg 4, 2023
 */

@Controller
@RequestMapping(value = {"/dtdd"})
public class ProductOfBrandController {

  @Autowired
  ProductService productService;
  
  @GetMapping(value = "/{brandName}")
  public String initPage() {
  
    return "tiles.productofbrand";
  }
  
  @PostMapping("/{brandName}")
  @ResponseBody
  public ResponseDataModel getAll(@RequestBody Map<String, Object> searchDataMap) {

    return productService.searchWithPagerUser(searchDataMap);
  }
}
