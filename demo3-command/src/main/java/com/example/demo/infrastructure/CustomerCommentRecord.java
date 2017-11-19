package com.example.demo.infrastructure;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "CustomerComment")
public class CustomerCommentRecord {

  @Id
  public String customerCommentId;

  public String productId;

  public String customerComment;
}
