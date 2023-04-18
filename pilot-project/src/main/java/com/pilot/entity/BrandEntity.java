package com.pilot.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * This class is used to declare properties and mapping them with BRAND table from database
 * 
 * @author PhuQuoc
 * @since Apr 11, 2023
 */
@Entity
@Table(name = "BRAND")
public class BrandEntity {

  @Id
  @Column(name = "BRAND_ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long brandId;

  @Column(name = "BRAND_NAME", length = 100, nullable = true)
  private String brandName;

  @Column(name = "DESCRIPTION", nullable = true)
  private String description;

  @Column(name = "LOGO", nullable = true)
  private String logo;

  @Transient
  private MultipartFile[] logoFiles;

  @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
  private List<ProductEntity> product;

  /**
   * @return the brandId
   */
  public Long getBrandId() {
    return brandId;
  }

  /**
   * @param brandId the brandId to set
   */
  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  /**
   * @return the brandName
   */
  public String getBrandName() {
    return brandName;
  }

  /**
   * @param brandName the brandName to set
   */
  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the logo
   */
  public String getLogo() {
    return logo;
  }

  /**
   * @param logo the logo to set
   */
  public void setLogo(String logo) {
    this.logo = logo;
  }

  /**
   * @return the logoFiles
   */
  public MultipartFile[] getLogoFiles() {
    return logoFiles;
  }

  /**
   * @param logoFiles the logoFiles to set
   */
  public void setLogoFiles(MultipartFile[] logoFiles) {
    this.logoFiles = logoFiles;
  }
}
