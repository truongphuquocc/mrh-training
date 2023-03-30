package com.demo.core.lab5;

public interface ATM {
  boolean withdraw(int id, double money);

  boolean deposit(int id, double money);

  double queryBalance(int money);

  boolean login(String username, String password);

  boolean logout(String username);
}
