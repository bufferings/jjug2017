package com.example.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.customer.Comment;
import com.example.demo.model.customer.CustomerComment;
import com.example.demo.model.customer.CustomerCommentId;
import com.example.demo.model.customer.CustomerCommentRepository;
import com.example.demo.model.customer.ProductId;

@Service
@Transactional
public class AddCustomerCommentUseCase {

  private final CustomerCommentRepository repository;

  private final KafkaTemplate<String, String> template;

  @Autowired
  public AddCustomerCommentUseCase(CustomerCommentRepository repository, KafkaTemplate<String, String> template) {
    this.repository = repository;
    this.template = template;
  }

  public void add(
      String aProductId,
      String aCustomerComment) {

    CustomerComment customerComment = CustomerComment.of(
        CustomerCommentId.create(), 
        ProductId.of(aProductId),
        Comment.of(aCustomerComment));

    repository.add(customerComment);
    template.send("demo3-topic", createMessage(customerComment));
  }
  
  private String createMessage(CustomerComment customerComment) {
    return customerComment.getProductId().value() + " " + customerComment.getComment().value();
  }
}
