/**
 * 
 */
package com.pilot.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import com.pilot.dao.ProductDao;
import com.pilot.dao.repository.ProductRepository;
import com.pilot.entity.BrandEntity;
import com.pilot.entity.ProductEntity;

/**
 * @author PhuQuoc
 * @since Apr 13, 2023
 */

@Repository
public class ProdcutDaoImpl implements ProductDao {

  @Autowired
  private ProductRepository repo;

  @Override
  public ProductEntity findByProductId(Long productId) {
    return repo.findById(productId).get();
  }

  @Override
  public ProductEntity findByProductName(String productName) {
    return repo.findByProductName(productName);
  }

  @Override
  public ProductEntity findByProductNameAndProductIdNot(String productName, Long productId) {
    return repo.findByProductNameAndProductIdNot(productName, productId);
  }

  @Override
  public Specification<ProductEntity> getSearchCriteria(Map<String, Object> searchConditionsMap) {

    return new Specification<ProductEntity>() {
      private static final long serialVersionUID = 1L;

      @SuppressWarnings("unchecked")
      @Override
      public Predicate toPredicate(Root<ProductEntity> productRoot, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (searchConditionsMap != null) {
          String keyword = (String) searchConditionsMap.get("keyword");
          String priceFrom = (String) searchConditionsMap.get("priceFrom");
          String priceTo = (String) searchConditionsMap.get("priceTo");
          List<String> brandIds = (List<String>) searchConditionsMap.get("brandIdFilter");
          List<String> prices = (List<String>) searchConditionsMap.get("priceFilter");
          String[] priceSplit;
          Join<ProductEntity, BrandEntity> brandRoot = productRoot.join("brand");

          // Keyword Predicate
          if (StringUtils.isNotEmpty(keyword)) {
            predicates.add(criteriaBuilder.or(
                criteriaBuilder.like(productRoot.get("productName"), "%" + keyword + "%"),
                criteriaBuilder.like(productRoot.get("description"), "%" + keyword + "%")));
          }

          // Price From Predicate
          if (StringUtils.isNotEmpty(priceFrom)) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(productRoot.get("price"),
                Double.parseDouble(priceFrom)));
          }

          // Price To Predicate
          if (StringUtils.isNotEmpty(priceTo)) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(productRoot.get("price"),
                Double.parseDouble(priceTo)));
          }

          // Brand Predicate
          if (!CollectionUtils.isEmpty(brandIds)) {
            List<Predicate> brandIdPredicateList = new ArrayList<>();
            for (String brandId : brandIds) {
              brandIdPredicateList
                  .add(criteriaBuilder.equal(brandRoot.get("brandId"), Long.parseLong(brandId)));
            }
            predicates.add(criteriaBuilder
                .or(brandIdPredicateList.toArray(new Predicate[brandIdPredicateList.size()])));
          }

          if (!CollectionUtils.isEmpty(prices)) {
            List<Predicate> pricePredicateList = new ArrayList<>();
            for (String price : prices) {
                priceSplit = price.split("-");
                pricePredicateList.add(criteriaBuilder.between(productRoot.get("price"),
                    Double.parseDouble(priceSplit[0]), Double.parseDouble(priceSplit[1])));
            }
            predicates.add(criteriaBuilder.or(pricePredicateList.toArray(new Predicate[pricePredicateList.size()])));
          }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
      }
    };
  }

  @Override
  public List<ProductEntity> findByBrand(Long brandId) {

    return repo.findByBrand(brandId);
  }

}
