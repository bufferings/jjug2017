package com.example.demo.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.customer.CustomerComment;
import com.example.demo.model.customer.CustomerCommentRepository;

@Component
public class DomaCustomerCommentRepository implements CustomerCommentRepository {
  
  private final CustomerCommentDao dao;
  
  @Autowired
  public DomaCustomerCommentRepository(CustomerCommentDao dao){
    this.dao = dao;
  }

  @Override
  public void add(CustomerComment customerComment) {
      dao.insert(convert(customerComment));
  }

  private CustomerCommentRecord convert(CustomerComment customerComment) {
    CustomerCommentRecord record = new CustomerCommentRecord();
    record.customerCommentId = customerComment.getCustomerCommentId().value();
    record.productId = customerComment.getProductId().value();
    record.customerComment = customerComment.getComment().value();
    return record;    
  }
}
