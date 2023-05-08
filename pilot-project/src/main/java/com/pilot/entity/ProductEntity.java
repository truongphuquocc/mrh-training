/**
 * 
 */
package com.pilot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.pilot.common.constant.Constants;
import com.pilot.common.util.CommonUtil;

/**
 * @author PhuQuoc
 * @since Apr 13, 2023
 */
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

  @Id
  @Column(name = "PRODUCT_ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  @Column(name = "PRODUCT_NAME", length = 100, nullable = true, unique = true)
  private String productName;

  @Column(name = "QUANTITY", nullable = true)
  private int quantity;

  @Column(name = "PRICE", nullable = true)
  private double price;

  @Column(name = "SALE_DATE", nullable = true)
  //@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
//  @Temporal(TemporalType.DATE)
//  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private Date saleDate;

  @Column(name = "IMAGE", length = 100, nullable = true)
  private String image;

  @Column(name = "DESCRIPTION", nullable = true)
  private String description;
  
  @Transient
  private MultipartFile[] imageFiles;
  
  @ManyToOne
  @JoinColumn(name = "BRAND_ID", nullable = true)
  private BrandEntity brand;
  /**
   * @return the imageFiles
   */
  public MultipartFile[] getImageFiles() {
    return imageFiles;
  }

  /**
   * @param imageFiles the imageFiles to set
   */
  public void setImageFiles(MultipartFile[] imageFiles) {
    this.imageFiles = imageFiles;
  }

  /**
   * @return the productId
   */
  public Long getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(Long productId) {
    this.productId = productId;
  }

  /**
   * @return the productName
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * @return the saleDate
   * @throws ParseException 
   */
  public String getSaleDate() {
    return CommonUtil.cvDateToString(saleDate, Constants.DATE_FORMAT_FOR_ddMMyy);
  }

  /**
   * @param saleDate the saleDate to set
   */
  public void setSaleDate(String saleDate) {
  
    this.saleDate = CommonUtil.cvStringToDate(saleDate, Constants.DATE_FORMAT_FOR_ddMMyy);
  }
//  public String getSaleDate() {
//    Locale locale = new Locale("vi","VN");
//    Date cvStringToDate = CommonUtil.cvStringToDate(saleDate, "yyyy-MM-dd");
//    String cvDateToString = CommonUtil.cvDateToString(cvStringToDate, "dd-MM-yyyy", locale);
//    return cvDateToString;
//  }
//
//  /**
//   * @param saleDate the saleDate to set
//   */
//  public void setSaleDate(String saleDate) {
//    Date cvStringToDate = CommonUtil.cvStringToDate(saleDate, "dd-MM-yyyy");
//    String cvDateToString = CommonUtil.cvDateToString(cvStringToDate, "yyyy-MM-dd");
//    this.saleDate = cvDateToString;
//  }

  /**
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * @param image the image to set
   */
  public void setImage(String image) {
    this.image = image;
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
   * @return the brand
   */
  public BrandEntity getBrand() {
    return brand;
  }

  /**
   * @param brand the brand to set
   */
  public void setBrand(BrandEntity brand) {
    this.brand = brand;
  }


}
