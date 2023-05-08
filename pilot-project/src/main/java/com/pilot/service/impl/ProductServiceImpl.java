/**
 * 
 */
package com.pilot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.pilot.common.constant.Constants;
import com.pilot.common.util.CommonUtil;
import com.pilot.common.util.FileHelper;
import com.pilot.dao.BrandDao;
import com.pilot.dao.ProductDao;
import com.pilot.dao.repository.ProductRepository;
import com.pilot.entity.BrandEntity;
import com.pilot.entity.ProductEntity;
import com.pilot.entity.ProductEntity;
import com.pilot.model.PagerModel;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.ProductService;

/**
 * @author PhuQuoc
 * @since Apr 14, 2023
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private final Logger LOGGER = LoggerFactory.getLogger(getClass());

  @Value("${parent.folder.images.product}")
  private String productImageFolderPath;

  @Autowired
  ProductDao productDao;
  @Autowired
  BrandDao brandDao;

  @Autowired
  ProductRepository productRepo;

  @Override
  public ResponseDataModel add(ProductEntity productEntity) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    try {
      if (findByProductName(productEntity.getProductName()) != null) {
        responseMsg = "Product Name is duplicated";
        responseCode = Constants.RESULT_CD_DUPL;
      } else {
        MultipartFile[] logoFiles = productEntity.getImageFiles();
        if (logoFiles != null && logoFiles[0].getSize() > 0) {
          String imagePath = FileHelper.addNewFile(productImageFolderPath, logoFiles);
          productEntity.setImage(imagePath);
        }
        productRepo.saveAndFlush(productEntity);
        responseMsg = "Product is added successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when adding brand";
      LOGGER.error("Error when adding brand: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public ResponseDataModel update(ProductEntity productEntity) {
    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    try {
      ProductEntity duplicatedBrand = productRepo.findByProductNameAndProductIdNot(
          productEntity.getProductName(), productEntity.getProductId());
      // Check if brand name existed
      if (duplicatedBrand != null) {
        responseMsg = "Brand Name is duplicated";
        responseCode = Constants.RESULT_CD_DUPL;
      } else {
        MultipartFile[] logoFiles = productEntity.getImageFiles();
        if (logoFiles != null && logoFiles[0].getSize() > 0) {
          String imagePath =
              FileHelper.editFile(productImageFolderPath, logoFiles, productEntity.getImage());
          productEntity.setImage(imagePath);;
        }
        productRepo.saveAndFlush(productEntity);
        responseMsg = "Product is updated successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when updating product";
      LOGGER.error("Errorr when updating product: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public ResponseDataModel findByProductIdForApi(Long productId) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    ProductEntity productEntity = null;
    try {
      productEntity = productDao.findByProductId(productId);
      if (productEntity != null) {
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when finding brand by ID";
      LOGGER.error("Error when finding brand by ID: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, productEntity);
  }

  @Override
  public ResponseDataModel delete(Long productId) {
    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    ProductEntity productEntity = productDao.findByProductId(productId);
    try {
      if (productEntity != null) {
        productRepo.deleteById(productId);
        productRepo.flush();

        // Remove image of brand from storage folder
        FileHelper.deleteFile(productEntity.getImage());
        responseMsg = "Product is deleted successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when deleting product";
      LOGGER.error("Error when delete product: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public ProductEntity findProductById(Long productId) {

    return productDao.findByProductId(productId);
  }

  @Override
  public ProductEntity findByProductName(String productName) {
    return productDao.findByProductName(productName);
  }

  @Override
  public ResponseDataModel searchWithPager(Map<String, Object> searchDataMap) {
    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    Map<String, Object> responseMap = new HashMap<>();
    try {
      int pageNumber = (int) searchDataMap.get("currentPage");
      Sort sortInfo = Sort.by(Sort.Direction.DESC, "productId");
      Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sortInfo);
      Page<ProductEntity> productEntitiesPage =
          productRepo.findAll(productDao.getSearchCriteria(searchDataMap), pageable);
      responseMap.put("productsList", productEntitiesPage.getContent());
      responseMap.put("brandsList", brandDao.findAll());
      responseMap.put("paginationInfo",
          new PagerModel(pageNumber, productEntitiesPage.getTotalPages()));
      responseCode = Constants.RESULT_CD_SUCCESS;
    } catch (Exception e) {
      responseMsg = e.getMessage();
      LOGGER.error("Error when get all product: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, responseMap);
  }
  
  @Override
  public ResponseDataModel searchWithPagerUser(Map<String, Object> searchDataMap) {
    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    Map<String, Object> responseMap = new HashMap<>();
    try {
      int pageNumber = (int) searchDataMap.get("currentPage");
      Sort sortInfo = Sort.by(Sort.Direction.DESC, "productId");
      Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE_PRODUCT, sortInfo);
      Page<ProductEntity> productEntitiesPage =
          productRepo.findAll(productDao.getSearchCriteria(searchDataMap), pageable);
      responseMap.put("productsListUser", productEntitiesPage.getContent());
      responseMap.put("paginationInfo",
          new PagerModel(pageNumber, productEntitiesPage.getTotalPages()));
      responseCode = Constants.RESULT_CD_SUCCESS;
    } catch (Exception e) {
      responseMsg = e.getMessage();
      LOGGER.error("Error when get all product: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, responseMap);
  }

  @Override
  public ResponseDataModel findByBrand2(Map<String, Object> searchDataMap) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    Map<String, Object> responseMap = new HashMap<>();
    try {
      long brandId = Long.parseLong(searchDataMap.get("brandId").toString());
      List<ProductEntity> productEntitiesPage =
          productDao.findByBrand(brandId);
      responseMap.put("productsListUser2", productEntitiesPage);
      responseCode = Constants.RESULT_CD_SUCCESS;
    } catch (Exception e) {
      responseMsg = e.getMessage();
      LOGGER.error("Error when get all product: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, responseMap);
  }

}
