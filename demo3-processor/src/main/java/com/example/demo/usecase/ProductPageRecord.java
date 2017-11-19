package com.example.demo.usecase;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "ProductPage")
public class ProductPageRecord {

  @Id
  public String productId;

  public String productName;

  public Integer commentCount;

  public String latestComment;
}
