package com.example.movieapp.service;

import com.example.movieapp.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqReceiver {
    @RabbitListener(queues = "${backend.rabbitmq.queue}")
    public void receivedMessage(Movie movie) {
        log.info("Recieved Message From RabbitMQ: " + movie);
    }
}
