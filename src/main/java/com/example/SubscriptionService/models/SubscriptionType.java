package com.example.SubscriptionService.models;

public enum SubscriptionType {
  MONTHLY(30,100),
  ANNUAL(365,500),
  WEEKLY(7,50);
  private final int durationDays;
  private final int price;
  SubscriptionType(int durationDays,int price){
    this.durationDays=durationDays;
    this.price=price;
  }

  @Override
  public String toString() {
    return "SubscriptionType{" +
      "durationDays=" + durationDays +
      ", price=" + price +
      '}';
  }
}
