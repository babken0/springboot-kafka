package com.example.springbootkafka.kafka;


import com.example.springbootkafka.model.CustomMessage;
import com.example.springbootkafka.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private final MessageService messageService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    public JsonKafkaConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "message_json", groupId = "my-group")
    public void consume(CustomMessage customMessage) {
        LOGGER.info(String.format("Json message receives: %s ", customMessage.toString()));
        messageService.saveMessage(customMessage);

    }
}
