package com.example.demo.model.customer;

public class ProductId {

  public static ProductId of(String value) {
    return new ProductId(value);
  }

  private final String value;

  private ProductId(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

}
