package com.demo.core.lab2;

import java.util.Scanner;

public class Employee {
  String name;
  int age;
  String job;
  float salary;
  String department;


  public Employee(String name, int age, String job, float salary, String department) {
    super();
    this.name = name;
    this.age = age;
    this.job = job;
    this.salary = salary;
    this.department = department;
  }

  public Employee() {
    super();
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {

    Employee employee = new Employee();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nhập tên nhân viên: ");
    employee.name = scanner.nextLine();

    System.out.print("Nhập công việc: ");
    employee.job = scanner.nextLine();

    System.out.print("Nhập tuổi: ");
    employee.age = scanner.nextInt();

    System.out.print("Nhập lương: ");
    employee.salary = scanner.nextFloat();


    if (employee.job.equals("developer")) {
      employee.department = "development";
    }
    if (employee.job.equals("‘tester’ ")) {
      employee.department = "QA";
    } else {
      employee.department = "master";
    }

    employee = new Employee(employee.name, employee.age, employee.job, employee.salary,
        employee.department);

    System.out.print("công việc: " + employee.department);

  }



}


