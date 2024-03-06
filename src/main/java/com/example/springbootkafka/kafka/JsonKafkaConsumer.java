package com.example.springbootkafka.kafka;


import com.example.springbootkafka.entity.Message;
import com.example.springbootkafka.model.CustomMessage;
import com.example.springbootkafka.repository.impl.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Autowired
    private MessageRepository messageRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(topics = "message_json",groupId = "my-group")
    public void consume(CustomMessage customMessage){
        LOGGER.info(String.format("Json message receives: %s ",customMessage.toString()));

        Message message = new Message(customMessage.getText());
        messageRepository.save(message);
    }
}
