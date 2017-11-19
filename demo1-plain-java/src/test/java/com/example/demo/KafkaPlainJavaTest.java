package com.example.demo;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;

public class KafkaPlainJavaTest {
  @Test
  public void gettingStartedProducer() {
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
      IntStream.rangeClosed(1, 10).forEach(i -> {
        try {
          producer.send(new ProducerRecord<>("demo1-topic", "my-key" + i, "my-value" + i)).get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      });
    }
  }

  @Test
  public void gettingStartedConsumer() {
    Properties properties = new Properties();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer");
    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
      consumer.subscribe(Arrays.asList("demo1-topic"));
      ConsumerRecords<String, String> records = consumer.poll(1000L);
      records.forEach(r -> System.err.println(r.key() + ":" + r.value()));
    }
  }
}