package com.demo.core.lab6;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
  public Connection con;

  public void KetNoi() throws ClassNotFoundException {
    String url = "jdbc:mysql://localhost:3306/quanlymuavetau";
    String username = "root";
    String password = "123456";

    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(url, username, password);

    } catch (Exception ex) {
      System.out.println("connect failure!");
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ConnectionTest cn = new ConnectionTest();
    try {
      cn.KetNoi();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

