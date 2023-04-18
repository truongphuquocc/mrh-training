/**
 * 
 */
package com.pilot.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.pilot.dao.ProductDao;
import com.pilot.dao.repository.ProductRepository;
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

      @Override
      public Predicate toPredicate(Root<ProductEntity> productRoot, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (searchConditionsMap != null) {
          String priceFrom = (String) searchConditionsMap.get("priceFrom");
          Double priceFromParse = Double.parseDouble(priceFrom);
          String priceTo = (String) searchConditionsMap.get("priceTo");
          Double priceToParse = Double.parseDouble(priceTo);
          String keyword = (String) searchConditionsMap.get("keyword");
          if (StringUtils.isNotEmpty(keyword) && priceFromParse == 0 && priceToParse == 0) {
            predicates.add(criteriaBuilder.or(
                criteriaBuilder.like(productRoot.get("productName"), "%" + keyword + "%"),
                criteriaBuilder.like(productRoot.get("brand").get("brandName"),
                    "%" + keyword + "%")));
          }
          if (StringUtils.isEmpty(keyword) && priceFromParse > 0 && priceToParse > 0) {
            predicates.add(criteriaBuilder.and(
                criteriaBuilder.between(productRoot.get("price"), priceFromParse, priceToParse)));
          }
          if (StringUtils.isNotEmpty(keyword) && priceFromParse > 0 && priceToParse > 0) {
            predicates.add(criteriaBuilder.and(
                criteriaBuilder.or(
                    criteriaBuilder.like(productRoot.get("productName"), "%" + keyword + "%"),
                    criteriaBuilder.like(productRoot.get("brand").get("brandName"),
                        "%" + keyword + "%")),
                criteriaBuilder.between(productRoot.get("price"), priceFromParse, priceToParse)));
          }
          if (StringUtils.isEmpty(keyword) && priceFromParse > 0 && priceToParse == 0) {
            predicates.add(criteriaBuilder.gt(productRoot.get("price"), priceFromParse));
          }
          if (StringUtils.isNotEmpty(keyword) && priceFromParse > 0 && priceToParse == 0) {
            predicates.add(
                criteriaBuilder.and(criteriaBuilder.gt(productRoot.get("price"), priceFromParse),
                    criteriaBuilder.or(
                        criteriaBuilder.like(productRoot.get("productName"), "%" + keyword + "%"),
                        criteriaBuilder.like(productRoot.get("brand").get("brandName"),
                            "%" + keyword + "%"))));
          }
          if (StringUtils.isEmpty(keyword) && priceFromParse == 0 && priceToParse > 0) {
            predicates.add(criteriaBuilder.lt(productRoot.get("price"), priceToParse));
          }
          if (StringUtils.isNotEmpty(keyword) && priceFromParse == 0 && priceToParse > 0) {
            predicates
                .add(criteriaBuilder.and(criteriaBuilder.lt(productRoot.get("price"), priceToParse),
                    criteriaBuilder.or(
                        criteriaBuilder.like(productRoot.get("productName"), "%" + keyword + "%"),
                        criteriaBuilder.like(productRoot.get("brand").get("brandName"),
                            "%" + keyword + "%"))));
          }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
      }
    };
  }

}
