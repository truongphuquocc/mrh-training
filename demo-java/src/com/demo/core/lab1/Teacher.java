package com.demo.core.lab1;

public class Teacher {
  int modelYear;
  String modelName;

  public Teacher(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Teacher myTeacher = new Teacher(1969, " Tam teaching Mathematics for Class 1" + "");
    System.out.println(myTeacher.modelYear + " " + myTeacher.modelName);
  }
}
