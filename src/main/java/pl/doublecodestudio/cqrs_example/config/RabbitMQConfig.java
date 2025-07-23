package pl.doublecodestudio.cqrs_example.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "user-exchange";
    public static final String CUSTOMER_NOTIFICATION_QUEUE = "customer-notification-queue";
    public static final String CUSTOMER_NOTIFICATION_ROUTING_KEY = "customer.notification.queue";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue customerNotificationQueue() {
        return new Queue(CUSTOMER_NOTIFICATION_QUEUE);
    }

    @Bean Binding customerNotificationBinding(Queue userNotificationQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customerNotificationQueue()).to(topicExchange()).with(CUSTOMER_NOTIFICATION_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }
}

