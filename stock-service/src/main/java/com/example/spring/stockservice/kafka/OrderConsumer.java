package com.example.spring.stockservice.kafka;

import com.example.spring.basedomains.dto.OrderEvent;
import com.example.spring.stockservice.model.Order;
import com.example.spring.stockservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    private OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}"
                    , groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        logger.info(String.format("Order event received in stock service => %s", event.toString()));

        // TODO: add database save the order event data into the database
        orderRepository.save(new Order(event.getOrder()));
    }
}
