package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DemoApplication {

  public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @KafkaListener(topics = "demo2-topic")
  public void listen(ConsumerRecord<?, ?> cr) throws Exception {
    logger.info(cr.toString());
  }

}
