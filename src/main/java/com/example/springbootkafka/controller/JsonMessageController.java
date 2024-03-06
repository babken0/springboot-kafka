package com.example.springbootkafka.controller;

import com.example.springbootkafka.kafka.JsonKafkaProducer;
import com.example.springbootkafka.model.CustomMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody CustomMessage customMessage) {

        kafkaProducer.sendMessage(customMessage);
        return ResponseEntity.ok("Message sent to kafka topic.");
    }
}
