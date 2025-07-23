package pl.doublecodestudio.cqrs_example.application.customer.query;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.domain.customer.port.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetCustomerQueryHandler {
    private final CustomerRepository customerRepository;

    public List<Customer> handle(GetCustomerQuery query) {
        return customerRepository.findAll();
    }
}
