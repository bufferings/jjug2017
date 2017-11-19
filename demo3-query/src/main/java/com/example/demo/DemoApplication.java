package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  private final ProductPageDao dao;
  
  @Autowired
  public DemoApplication(ProductPageDao dao) {
    this.dao = dao;
  }
  
  @GetMapping
  public List<ProductPageRecord> getAll(){
    return dao.findAll();
  }
}

