/**
 * 
 */
package com.pilot.user.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pilot.entity.ProductEntity;
import com.pilot.service.ProductService;


/**
 * @author PhuQuoc
 * @since 28 thg 4, 2023
 */

@Controller
@RequestMapping(value = {"/dtdd-detail"})
public class DetailProductController {

  @Autowired
  private ProductService productService;

  @GetMapping(value = {"/{productName}"})
  public String initPage(@PathVariable("productName") String productName, HttpServletRequest request, Model model) {
    ProductEntity productEntity = productService.findByProductName(productName.replaceAll("-", " "));
    if (productEntity != null && productName != null) {
      model.addAttribute("productDetail", productEntity);
      model.addAttribute("specificPageTitle", productEntity.getProductName());
    }
    return "tiles.detailproduct";
  }
}
