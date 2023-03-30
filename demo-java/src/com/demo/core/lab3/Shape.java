package com.demo.core.lab3;

public abstract class Shape {
  public String color;

  public abstract double getArea();


}


class Rectagle extends Shape {
  double height;
  double width;


  public Rectagle(double height, double width) {
    super();
    this.height = height;
    this.width = width;
  }


  @Override
  public double getArea() {
    // TODO Auto-generated method stub
    return this.height * this.width;
  }



}

//
// class Triangle extends Shape1 {
// public int length;
// public int width;
//
// @Override
// public double getArea(int length, int width) {
// this.length = length;
// this.width = width;
// }
//
// }


class Main {
  public static void main(String[] args) {
    Rectagle rectangle = new Rectagle(4, 5);
    System.out.println("Area Rectangle: " + rectangle.getArea());
  }

}
