package pl.doublecodestudio.cqrs_example.interfaces.web.customer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.doublecodestudio.cqrs_example.application.customer.command.AddCustomerCommand;
import pl.doublecodestudio.cqrs_example.application.customer.command.AddCustomerCommandHandler;
import pl.doublecodestudio.cqrs_example.application.customer.query.GetCustomerQuery;
import pl.doublecodestudio.cqrs_example.application.customer.query.GetCustomerQueryHandler;
import pl.doublecodestudio.cqrs_example.interfaces.web.customer.dto.CustomerResponseDto;
import pl.doublecodestudio.cqrs_example.interfaces.web.customer.mapper.CustomerMapper;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {
    private final AddCustomerCommandHandler addHandler;
    private final GetCustomerQueryHandler getHandler;
    private final CustomerMapper customerMapper;

    @PostMapping
    public void addCustomer(@RequestBody @Valid AddCustomerCommand command) {
        addHandler.handle(command);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerMapper.toDto(getHandler.handle(new GetCustomerQuery()));
    }
}
