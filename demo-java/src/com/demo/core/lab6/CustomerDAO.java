package com.demo.core.lab6;

import java.util.ArrayList;


public interface CustomerDAO {
  public Customer searchCustomer(int key) throws Exception;

  public int addCustomer(int CMND, String TenKhachHang, String GaDen, int GiaTien) throws Exception;

  public ArrayList<Customer> getCustomer() throws Exception;

  public boolean deleteCustimer(int CMND) throws Exception;

  public int updateCustomer(int CMND, String TenKhachHang, String GaDen, int GiaTien)
      throws Exception;
}
