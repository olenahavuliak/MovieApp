package com.example.movieapp.config.rabitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqDirectConfigExchangeType {

    public static final String QUEUE_MOVIE = "movieQueue";
    public static final String QUEUE_DIRECTOR = "directorQueue";
    public static final String EXCHANGE = "direct-exchange";
    public static final String MOVIE_ROUTING_KEY = "movie";
    public static final String DIRECTOR_ROUTING_KEY = "director";

    public static final
    @Bean
    Queue movieQueue() {
        return new Queue(QUEUE_MOVIE, false);
    }

    @Bean
    Queue directorQueue() {
        return new Queue(QUEUE_DIRECTOR, false);
    }


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding marketingBinding(Queue movieQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(movieQueue).to(directExchange).with(MOVIE_ROUTING_KEY);
    }

    @Bean
    Binding financeBinding(Queue directorQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directorQueue).to(directExchange).with(DIRECTOR_ROUTING_KEY);
    }

}
