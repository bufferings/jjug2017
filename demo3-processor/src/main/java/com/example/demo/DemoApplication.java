package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.demo.usecase.ProductPageProjectionService;

@SpringBootApplication
public class DemoApplication {

  public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  private final ProductPageProjectionService service;
  
  @Autowired
  public DemoApplication(ProductPageProjectionService service) {
    this.service = service;
  }
  

  @KafkaListener(topics = "demo3-topic")
  public void listen(ConsumerRecord<?, ?> cr) throws Exception {
    String value = (String)cr.value();
    String[] values = value.split(" ");

    String productId = values[0];
    String comment = values[1];
    
    service.update(productId, comment);
  }

}

