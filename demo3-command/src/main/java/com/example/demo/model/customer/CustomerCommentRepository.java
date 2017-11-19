package com.example.demo.model.customer;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCommentRepository {

  void add(CustomerComment customerComment);
}
