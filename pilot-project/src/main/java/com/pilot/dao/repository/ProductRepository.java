/**
 * 
 */
package com.pilot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.pilot.entity.ProductEntity;

/**
 * @author PhuQuoc
 * @since Apr 14, 2023
 */
@Repository
public interface ProductRepository
    extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {

  ProductEntity findByProductName(String productName);

  ProductEntity findByProductNameAndProductIdNot(String productName, Long productId);
}
