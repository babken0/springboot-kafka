package com.example.springbootkafka.repository.impl;

import com.example.springbootkafka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    <S extends Message> S save(S entity);
}
