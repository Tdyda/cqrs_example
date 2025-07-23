package pl.doublecodestudio.cqrs_example.infrastructure.customer.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.domain.customer.port.CustomerRepository;
import pl.doublecodestudio.cqrs_example.infrastructure.customer.messaging.RabbitCustomerPublisher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
@RequiredArgsConstructor
public class CompositeCustomerRepository implements CustomerRepository {
    private final JpaCustomerRepository jpa;
    private final RabbitCustomerPublisher rabbit;

    @Override
    public void save(Customer customer) {
        jpa.save(customer);
        rabbit.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return jpa.findById(id);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return jpa.findByEmail(email);
    }
}
