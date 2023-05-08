package com.pilot.service;

import java.util.List;
import java.util.Map;
import com.pilot.entity.BrandEntity;
import com.pilot.model.ResponseDataModel;

/**
 * This interface is used to declare functions to handle logic and business for Brand Entities
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
public interface BrandService {

  ResponseDataModel add(BrandEntity brandEntity);

  ResponseDataModel update(BrandEntity brandEntity);

  ResponseDataModel findByBrandIdForApi(Long brandId);

  ResponseDataModel delete(Long brandId);

  //List<BrandEntity> getAll();

  BrandEntity findByBrandId(Long brandId);

  BrandEntity findByBrandName(String brandName);

  ResponseDataModel searchWithPager(Map<String, Object> searchDataMap);
  
  ResponseDataModel getAll(Map<String, Object> searchDataMap);
}
