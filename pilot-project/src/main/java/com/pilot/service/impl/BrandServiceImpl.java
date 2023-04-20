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
import com.pilot.common.util.FileHelper;
import com.pilot.dao.BrandDao;
import com.pilot.entity.BrandEntity;
import com.pilot.model.PagerModel;
import com.pilot.model.ResponseDataModel;
import com.pilot.service.BrandService;

/**
 * This class is used to implement functions to handle logic and business for Brand Entities
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

  private final Logger LOGGER = LoggerFactory.getLogger(getClass());

  @Value("${parent.folder.images.brand}")
  private String brandLogoFolderPath;

  @Autowired
  BrandDao brandDao;

  @Override
  public ResponseDataModel add(BrandEntity brandEntity) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    try {
      if (findByBrandName(brandEntity.getBrandName()) != null) {
        responseMsg = "Brand Name is duplicated";
        responseCode = Constants.RESULT_CD_DUPL;
      } else {
        MultipartFile[] logoFiles = brandEntity.getLogoFiles();
        if (logoFiles != null && logoFiles[0].getSize() > 0) {
          String imagePath = FileHelper.addNewFile(brandLogoFolderPath, logoFiles);
          brandEntity.setLogo(imagePath);
        }
        brandDao.saveAndFlush(brandEntity);
        responseMsg = "Brand is added successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when adding brand";
      LOGGER.error("Error when adding brand: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public ResponseDataModel update(BrandEntity brandEntity) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    try {
      BrandEntity duplicatedBrand = brandDao
          .findByBrandNameAndBrandIdNot(brandEntity.getBrandName(), brandEntity.getBrandId());

      // Check if brand name existed
      if (duplicatedBrand != null) {
        responseMsg = "Brand Name is duplicated";
        responseCode = Constants.RESULT_CD_DUPL;
      } else {
        MultipartFile[] logoFiles = brandEntity.getLogoFiles();
        if (logoFiles != null && logoFiles[0].getSize() > 0) {
          String imagePath =
              FileHelper.editFile(brandLogoFolderPath, logoFiles, brandEntity.getLogo());
          brandEntity.setLogo(imagePath);
        }
        brandDao.saveAndFlush(brandEntity);
        responseMsg = "Brand is updated successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when updating brand";
      LOGGER.error("Errorr when updating brand: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public ResponseDataModel delete(Long brandId) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    BrandEntity brandEntity = brandDao.findByBrandId(brandId);
    try {
      if (brandEntity != null) {
        brandDao.deleteById(brandId);
        brandDao.flush();

        // Remove image of brand from storage folder
        FileHelper.deleteFile(brandEntity.getLogo());
        responseMsg = "Brand is deleted successfully";
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when deleting brand";
      LOGGER.error("Error when delete brand: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg);
  }

  @Override
  public BrandEntity findByBrandId(Long brandId) {
    return brandDao.findByBrandId(brandId);
  }

  @Override
  public List<BrandEntity> getAll() {
    return brandDao.findAll(Sort.by(Sort.Direction.DESC, "brandId"));
  }

  @Override
  public BrandEntity findByBrandName(String brandName) {
    return brandDao.findByBrandName(brandName);
  }

  @Override
  public ResponseDataModel searchWithPager(Map<String, Object> searchDataMap) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    Map<String, Object> responseMap = new HashMap<>();
    try {
      int pageNumber = (int) searchDataMap.get("currentPage");
      Sort sortInfo = Sort.by(Sort.Direction.DESC, "brandId");
      Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sortInfo);
      Page<BrandEntity> brandEntitiesPage =
          brandDao.findAll(BrandDao.getSearchCriteria(searchDataMap), pageable);
      responseMap.put("brandsList", brandEntitiesPage.getContent());
      responseMap.put("paginationInfo",
          new PagerModel(pageNumber, brandEntitiesPage.getTotalPages()));
      responseCode = Constants.RESULT_CD_SUCCESS;
    } catch (Exception e) {
      responseMsg = e.getMessage();
      LOGGER.error("Error when get all brand: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, responseMap);
  }

  @Override
  public ResponseDataModel findByBrandIdForApi(Long brandId) {

    int responseCode = Constants.RESULT_CD_FAIL;
    String responseMsg = StringUtils.EMPTY;
    BrandEntity brandEntity = null;
    try {
      brandEntity = brandDao.findByBrandId(brandId);
      if (brandEntity != null) {
        responseCode = Constants.RESULT_CD_SUCCESS;
      }
    } catch (Exception e) {
      responseMsg = "Error when finding brand by ID";
      LOGGER.error("Error when finding brand by ID: {}", e);
    }
    return new ResponseDataModel(responseCode, responseMsg, brandEntity);
  }
}
