/**
 * 
 */
package com.pilot.user.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pilot.entity.ProductEntity;
import com.pilot.service.ProductService;


/**
 * @author PhuQuoc
 * @since 28 thg 4, 2023
 */

@Controller
public class DetailProductController {

  @Autowired
  private ProductService productService;

  @GetMapping(value = {"/detailproduct"})
  public String initPage(@RequestParam(value = "id", required = false) Long productId,
      HttpServletRequest request, Model model) {
    ProductEntity productEntity = productService.findProductById(productId);
    if (productEntity != null && productId != null) {
      model.addAttribute("productDetail", productEntity);
      model.addAttribute("specificPageTitle", productEntity.getProductName());
    }
    return "tiles.detailproduct";
  }
}
