package com.example.demo.model.customer;

public class Comment {

  public static Comment of(String value) {
    return new Comment(value);
  }

  private final String value;

  private Comment(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
