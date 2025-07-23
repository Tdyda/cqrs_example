package pl.doublecodestudio.cqrs_example.infrastructure.customer.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import pl.doublecodestudio.cqrs_example.config.RabbitMQConfig;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.domain.customer.port.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RabbitCustomerPublisher implements CustomerRepository {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void save(Customer customer) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.CUSTOMER_NOTIFICATION_ROUTING_KEY,
                customer
        );
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }
}
