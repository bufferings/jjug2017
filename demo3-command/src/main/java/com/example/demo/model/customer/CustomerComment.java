package com.example.demo.model.customer;

public class CustomerComment {

  public static CustomerComment of(CustomerCommentId customerCommentId, ProductId productId, Comment comment) {
    return new CustomerComment(customerCommentId, productId, comment);
  }

  private final CustomerCommentId customerCommentId;

  private final ProductId productId;

  private final Comment comment;

  private CustomerComment(CustomerCommentId customerCommentId, ProductId productId, Comment comment) {
    this.customerCommentId = customerCommentId;
    this.productId = productId;
    this.comment = comment;
  }

  public CustomerCommentId getCustomerCommentId() {
    return customerCommentId;
  }

  public ProductId getProductId() {
    return productId;
  }

  public Comment getComment() {
    return comment;
  }

}
