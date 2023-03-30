package com.demo.core.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void searhCustomer(int key) {
    Customer customer = new Customer();
    CustomerDAOImpl cus = new CustomerDAOImpl();
    try {
      customer = cus.searchCustomer(key);
      int check = cus.searchCustomer(key).getCMND();
      if (check == key) {
        System.out.println("Tên Khách Hàng: " + customer.getTenKhachHang());
        System.out.println("Ga đến: " + customer.getGaDen());
        System.out.println("Giá tiền: " + customer.getGiaTien());
        System.out.println("============================");
      } else {
        System.out.println("CMND không tồn tại trong hệ thống");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void addCustomer() {
    Scanner scan = new Scanner(System.in);
    CustomerDAOImpl cus = new CustomerDAOImpl();

    System.out.println("Nhập thông tin khách hàng");
    Customer customer = new Customer();

    System.out.println("Nhập CMND: ");
    customer.CMND = scan.nextInt();
    scan.nextLine();

    int check = getCustomer(customer.CMND).getCMND();
    if (check != customer.CMND) {
      System.out.println("Nhập họ tên khách hàng: ");
      customer.TenKhachHang = scan.nextLine();

      System.out.println("Nhập Ga đến: ");
      customer.GaDen = scan.nextLine();

      System.out.println("Nhập giá tiền: ");
      customer.GiaTien = scan.nextInt();
      scan.nextLine();
      System.out.println("Khách hàng sau khi thêm: ");
      try {
        cus.addCustomer(customer.CMND, customer.TenKhachHang, customer.GaDen, customer.GiaTien);
        searhCustomer(customer.CMND);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Chứng minh nhân dân đã tồn tại trong hệ thống");
    }

  }

  public static Customer getCustomer(int key) {
    Customer customer = new Customer();
    CustomerDAOImpl cus = new CustomerDAOImpl();
    try {
      customer = cus.searchCustomer(key);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return customer;
  }

  public static void getALlCustomers() {
    CustomerDAOImpl cus = new CustomerDAOImpl();
    ArrayList<Customer> ds = new ArrayList<Customer>();
    try {
      ds = cus.getCustomer();
      for (Customer item : ds) {
        System.out.println("STT: " + (ds.indexOf(item) + 1));
        System.out.println("Tên Khách Hàng: " + item.getTenKhachHang());
        System.out.println("Ga đến: " + item.getGaDen());
        System.out.println("Ga đến: " + item.getGiaTien());
        System.out.println("============================");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void updateCustomer(int cmnd) {
    CustomerDAOImpl cus = new CustomerDAOImpl();
    Customer customer = new Customer();
    Scanner scan = new Scanner(System.in);
    try {
      customer = getCustomer(cmnd);
      if (customer.getCMND() == cmnd) {
        System.out.println("Thông tin khách hàng cập nhật");
        searhCustomer(cmnd);

        System.out.println("Nhập họ tên khách hàng: ");
        customer.TenKhachHang = scan.nextLine();

        System.out.println("Nhập Ga đến: ");
        customer.GaDen = scan.nextLine();

        System.out.println("Nhập giá tiền: ");
        customer.GiaTien = scan.nextInt();
        scan.nextLine();

        cus.updateCustomer(cmnd, customer.getTenKhachHang(), customer.getGaDen(),
            customer.getGiaTien());
        System.out.print("Khách hàng sau khi sửa: ");

        searhCustomer(cmnd);
      } else {
        System.out.println("CMND Không tồn tại trong hệ thống");
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }



  public static void main(String[] args) throws Exception {
    while (true) {
      System.out.println("QUẢN LÝ MUA VÉ TÀU");
      System.out.println("SELECT ONE");
      System.out.println("1.Thêm 1 khách hàng mới");
      System.out.println("2.Hiển thị tất cả các khách hàng đang mua vé");
      System.out.println("3.Tìm 1 khách hàng theo CMND");
      System.out.println("4.Xóa 1 một khách hàng");
      System.out.println("5.Update dữ liệu theo CMND");

      int c;
      Scanner scan = new Scanner(System.in);
      System.out.print("NHẬP LỰA CHỌN CỦA BẠN: ");
      c = scan.nextInt();
      CustomerDAOImpl cus = new CustomerDAOImpl();
      Customer customer = new Customer();
      switch (c) {
        case 1: {
          System.out.println("\n\tTHÊM KHÁCH HÀNG\n\t");
          addCustomer();
          break;
        }
        case 2: {
          System.out.println("\n\tDANH SÁCH KHÁCH HÀNG\n\t");
          getALlCustomers();
          break;
        }
        case 3: {
          int key;
          System.out.println("\n\tTÌM KIẾM KHÁCH HÀNG\n\t");
          System.out.println("Nhập CMND cần tìm kiếm: ");
          key = scan.nextInt();
          searhCustomer(key);
          break;
        }
        case 4: {
          System.out.println("Nhập Khách Hàng Muốn Xoá:");
          customer.CMND = scan.nextInt();
          cus.deleteCustimer(customer.CMND);
          System.out.println("Danh sách sau khi xoá :");
          searhCustomer(customer.CMND);
          break;
        }
        case 5: {
          int key;
          System.out.println("\n\tCẬP NHẬT KHÁCH HÀNG\n\t");
          System.out.println("Nhập CMND cần cập nhật: ");
          key = scan.nextInt();
          updateCustomer(key);
          break;
        }
      }
    }

  }
}
