package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.usecase.AddCustomerCommentUseCase;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static void main(
      String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  private AddCustomerCommentUseCase addCustomerCommentUseCase;

  @Autowired
  public DemoApplication(AddCustomerCommentUseCase addCustomerCommentUseCase) {
    this.addCustomerCommentUseCase = addCustomerCommentUseCase;
  }

  private static final String MAGURO_ID = "3926d0ad-5638-4ed1-b16a-b09197ddcc10";

  @GetMapping("{comment}")
  public void sample(@PathVariable String comment) {
    addCustomerCommentUseCase.add(MAGURO_ID, comment);
  }

}
