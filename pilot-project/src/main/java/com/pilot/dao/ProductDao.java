package com.pilot.dao;

import java.util.Map;
import org.springframework.data.jpa.domain.Specification;
import com.pilot.entity.ProductEntity;

/**
 * @author PhuQuoc
 * @since Apr 13, 2023
 */
public interface ProductDao {
  ProductEntity findByProductId(Long productId);

  ProductEntity findByProductName(String productName);

  ProductEntity findByProductNameAndProductIdNot(String productName, Long productId);

  Specification<ProductEntity> getSearchCriteria(Map<String, Object> searchConditionsMap);
}
