/**
 * 
 */
package com.pilot.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

  @Transactional
  @Query(value = "SELECT * FROM PRODUCT P WHERE P.BRAND_ID = :brandId",nativeQuery = true)
  List<ProductEntity> findByBrand(@Param("brandId") Long brandId);
  
  @Transactional
  @Query(value = "SELECT * FROM PRODUCT P LEFT JOIN BRAND B ON P.BRAND_ID = B.BRAND_ID WHERE P.PRODUCT_NAME LIKE %:keyword% OR B.BRAND_NAME LIKE %:keyword%",nativeQuery = true)
  List<ProductEntity> findByProductOrBrandName(@Param("keyword") String keyword);
}
