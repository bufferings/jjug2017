package com.example.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductPageProjectionService {

  private ProductPageDao dao;
  
  @Autowired
  public ProductPageProjectionService( ProductPageDao dao){
    this.dao = dao;
  }
  
  public void update(String productId, String comment){
    ProductPageRecord record = dao.findById(productId);
    record.commentCount++;
    record.latestComment = comment;
    dao.update(record);
  }
  
}
