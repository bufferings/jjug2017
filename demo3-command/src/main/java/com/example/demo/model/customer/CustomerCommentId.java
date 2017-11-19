package com.example.demo.model.customer;

import java.util.UUID;

public class CustomerCommentId {

  public static CustomerCommentId create() {
    return new CustomerCommentId(UUID.randomUUID().toString());
  }

  private final String value;

  private CustomerCommentId(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }

}
