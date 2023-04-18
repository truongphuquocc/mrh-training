/**
 * 
 */
package com.training.service;

import java.util.List;
import java.util.Map;
import com.pilot.entity.ProductEntity;
import com.pilot.model.ResponseDataModel;

/**
 * @author PhuQuoc
 * @since Apr 14, 2023
 */
public interface ProductService {
  
  ResponseDataModel add (ProductEntity productEntity);
  
  ResponseDataModel update (ProductEntity productEntity);
  
  ResponseDataModel findByProductIdForApi (Long productId);
  
  ResponseDataModel delete (Long productId);
  
  ProductEntity findProductById (Long productId);
  
  ProductEntity findByProductName(String productName);

  ResponseDataModel searchWithPager(Map<String, Object> searchDataMap);
}
