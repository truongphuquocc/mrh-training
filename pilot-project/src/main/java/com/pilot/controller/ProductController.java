/**
 * 
 */
package com.pilot.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pilot.dao.ProductDao;
import com.pilot.entity.BrandEntity;
import com.pilot.entity.ProductEntity;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.ProductService;

/**
 * @author PhuQuoc
 * @since Apr 14, 2023
 */
@Controller
@RequestMapping(value = {"/product"})
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  ProductDao prd;

  @GetMapping
  public String initPage(Model model) {
    return "tiles.product";
  }

  @PostMapping("/api/search")
  @ResponseBody
  public ResponseDataModel searchWithPager(@RequestBody Map<String, Object> searchDataMap) {
    
    return productService.searchWithPager(searchDataMap);
  }

  @GetMapping("/api/findById")
  @ResponseBody
  public ResponseDataModel findProductBy(@RequestParam("id") Long productId) {
    
    return productService.findByProductIdForApi(productId);
  }
  
  @PostMapping("/api/add")
  @ResponseBody
  public ResponseDataModel add(@ModelAttribute ProductEntity productEntity) {
    return productService.add(productEntity);
  }
  
  @DeleteMapping(value = {"/api/delete/{productId}"})
  @ResponseBody
  public ResponseDataModel delete(@PathVariable("productId") Long productId) {
    return productService.delete(productId);
  }
  
  @PostMapping(value = {"/api/update"})
  @ResponseBody
  public ResponseDataModel update(@ModelAttribute ProductEntity productEntity) {
    return productService.update(productEntity);
  }


}
