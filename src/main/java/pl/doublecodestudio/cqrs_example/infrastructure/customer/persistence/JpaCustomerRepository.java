package pl.doublecodestudio.cqrs_example.infrastructure.customer.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.domain.customer.port.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JpaCustomerRepository implements CustomerRepository {
    private final SpringDataCustomerRepository springDataRepository;

    @Override
    public void save(Customer customer) {
        JpaCustomerEntity entity = new JpaCustomerEntity(customer.getId(), customer.getName(), customer.getEmail());
        springDataRepository.save(entity);
        log.info("Saving customer with id {}", entity.getId());
    }

    @Override
    public List<Customer> findAll() {
        return springDataRepository.findAll().stream()
                .map(e -> new Customer(e.getId(), e.getName(), e.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return springDataRepository.findById(id)
                .map(e -> new Customer(e.getId(), e.getName(), e.getEmail()));
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return springDataRepository.findByEmail(email)
                .map(e -> new Customer(e.getId(), e.getName(), e.getEmail()));
    }
}
