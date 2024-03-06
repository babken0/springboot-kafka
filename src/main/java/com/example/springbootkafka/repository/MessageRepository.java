package com.example.springbootkafka.repository;

import com.example.springbootkafka.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    <S extends Message> S save(S entity);
}
