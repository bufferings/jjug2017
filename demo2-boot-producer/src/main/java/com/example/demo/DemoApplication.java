package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  private final KafkaTemplate<String, String> template;

  @Autowired
  public DemoApplication(KafkaTemplate<String, String> template) {
    this.template = template;
  }

  @GetMapping("{value}")
  public void sample(@PathVariable String value) {
    template.send("demo2-topic", value);
  }

}
