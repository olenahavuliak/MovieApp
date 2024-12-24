package com.example.movieapp.service;

import com.example.movieapp.model.Director;
import com.example.movieapp.model.Movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${backend.rabbitmq.exchange}")
    private String exchange;

    @Value("${backend.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Movie movie) {
        rabbitTemplate.convertAndSend(exchange, routingkey, movie);
        log.info("Send msg = {} ", movie);
    }
    public void send(Director director) {
        rabbitTemplate.convertAndSend(exchange, routingkey, director);
        log.info("Send msg = {} ", director);
    }
}
