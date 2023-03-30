package com.demo.core.lab6;

public class Customer {
  public int CMND;
  public String TenKhachHang;
  public String GaDen;
  public int GiaTien;

  public int getCMND() {
    return CMND;
  }

  public void setCMND(int cMND) {
    CMND = cMND;
  }

  public String getTenKhachHang() {
    return TenKhachHang;
  }

  public void setTenKhachHang(String tenKhachHang) {
    TenKhachHang = tenKhachHang;
  }

  public String getGaDen() {
    return GaDen;
  }

  public void setGaDen(String gaDen) {
    GaDen = gaDen;
  }

  public int getGiaTien() {
    return GiaTien;
  }

  public void setGiaTien(int giaTien) {
    GiaTien = giaTien;
  }

  public Customer(int cMND, String tenKhachHang, String gaDen, int giaTien) {
    super();
    CMND = cMND;
    TenKhachHang = tenKhachHang;
    GaDen = gaDen;
    GiaTien = giaTien;
  }

  public Customer() {
    super();
    // TODO Auto-generated constructor stub
  }
}
