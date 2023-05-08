/**
 * 
 */
package com.pilot.user.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.BrandService;
import com.pilot.service.ProductService;

/**
 * @author PhuQuoc
 * @since 25 thg 4, 2023
 */
@Controller
@RequestMapping(value = {"/home"})
public class UserController {
  
  @Autowired
  BrandService brandService;
  
  @Autowired
  ProductService productService;
  
  @GetMapping
  public String initPage() {
      return "tiles.homepage";
  }
  
  @PostMapping("/api/getall")
  @ResponseBody
  public ResponseDataModel getAll(@RequestBody Map<String, Object> searchDataMap) {
    return brandService.getAll(searchDataMap);
  }
  
  @PostMapping("/api/getproduct")
  @ResponseBody
  public ResponseDataModel getProduct(@RequestBody Map<String, Object> searchDataMap) {
    return productService.searchWithPagerUser(searchDataMap);
  }
  
//  @PostMapping(value = {"/productofbrand/{brandId}"})
//  @ResponseBody
//  public ResponseDataModel getProductBybranId(@PathVariable("brandId") Long brandId) {
//    return productService.findByBrand(brandId);
//  }
}
