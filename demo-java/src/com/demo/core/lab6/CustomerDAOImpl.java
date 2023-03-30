package com.demo.core.lab6;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class CustomerDAOImpl implements CustomerDAO {
  ConnectionTest cn = new ConnectionTest();

  @Override
  public Customer searchCustomer(int key) throws Exception {
    cn.KetNoi();
    Customer customer = new Customer();
    String sql = "select * from khachhang where CMND = ?";
    PreparedStatement cmd = cn.con.prepareStatement(sql);
    cmd.setInt(1, key);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      int cmnd = rs.getInt("CMND");
      String tenKhachHang = rs.getString("TenKhachHang");
      String gaDen = rs.getString("GaDen");
      int giaTien = rs.getInt("GiaTien");
      customer = new Customer(cmnd, tenKhachHang, gaDen, giaTien);
    }
    rs.close();
    cn.con.close();
    return customer;
  }

  @Override
  public int addCustomer(int CMND, String TenKhachHang, String GaDen, int GiaTien)
      throws Exception {
    cn.KetNoi();
    int rs;
    String sql = "insert into KhachHang (CMND, TenKhachHang, GaDen, GiaTien) values (?,?,?,?)";
    PreparedStatement cmd = cn.con.prepareStatement(sql);
    cmd.setInt(1, CMND);
    cmd.setString(2, TenKhachHang);
    cmd.setString(3, GaDen);
    cmd.setInt(4, GiaTien);
    rs = cmd.executeUpdate();
    cn.con.close();
    return rs;
  }

  @Override
  public ArrayList<Customer> getCustomer() throws Exception {
    cn.KetNoi();
    ArrayList<Customer> ds = new ArrayList<Customer>();
    String sql = "select * from khachhang";
    PreparedStatement cmd = cn.con.prepareStatement(sql);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      int cmnd = rs.getInt("CMND");
      String tenKhachHang = rs.getString("TenKhachHang");
      String gaDen = rs.getString("GaDen");
      int giaTien = rs.getInt("GiaTien");
      Customer sp = new Customer(cmnd, tenKhachHang, gaDen, giaTien);
      ds.add(sp);
    }
    rs.close();
    cn.con.close();
    return ds;
  }

  @Override
  public boolean deleteCustimer(int CMND) throws Exception {
    // TODO Auto-generated method stub
    try {
      cn.KetNoi();
      String mysql = "delete from quanlymuavetau.customer where CMND = ?";
      PreparedStatement cmd = cn.con.prepareStatement(mysql);
      cmd.setInt(1, CMND);
      cmd.executeUpdate();
      return true;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public int updateCustomer(int CMND, String TenKhachHang, String GaDen, int GiaTien)
      throws Exception {
    cn.KetNoi();
    int rs;
    String sql = "Update KhachHang set CMND=?, TenKhachHang=?, GaDen=?, GiaTien=? where CMND=? ";
    PreparedStatement cmd = cn.con.prepareStatement(sql);
    cmd.setInt(1, CMND);
    cmd.setString(2, TenKhachHang);
    cmd.setString(3, GaDen);
    cmd.setInt(4, GiaTien);
    cmd.setInt(5, CMND);
    rs = cmd.executeUpdate();
    cn.con.close();
    return rs;
  }

}
