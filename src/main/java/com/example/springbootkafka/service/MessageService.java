package com.example.springbootkafka.service;

import com.example.springbootkafka.entity.Message;
import com.example.springbootkafka.model.CustomMessage;
import com.example.springbootkafka.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(CustomMessage customMessage) {
        Message message = new Message(customMessage.getText());
        messageRepository.save(message);
    }
}
