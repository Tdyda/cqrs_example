package pl.doublecodestudio.cqrs_example.domain.customer.port;

import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    void save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(UUID id);

    Optional<Customer> findByEmail(String email);
}
