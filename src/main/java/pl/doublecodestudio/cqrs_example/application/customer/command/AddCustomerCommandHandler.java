package pl.doublecodestudio.cqrs_example.application.customer.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.domain.customer.port.CustomerRepository;
import pl.doublecodestudio.cqrs_example.exception.customer.EmailAlreadyExistsException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddCustomerCommandHandler {
    private final CustomerRepository customerRepository;

    public void handle(AddCustomerCommand customerCommand) {
        customerRepository.findByEmail(customerCommand.getEmail())
                .ifPresent(c -> {
                    throw new EmailAlreadyExistsException(customerCommand.getEmail());
                });

        Customer customer = new Customer(UUID.randomUUID(), customerCommand.getName(), customerCommand.getEmail());
        customerRepository.save(customer);
    }
}
