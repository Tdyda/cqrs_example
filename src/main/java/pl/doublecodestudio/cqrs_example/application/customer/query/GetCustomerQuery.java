package pl.doublecodestudio.cqrs_example.application.customer.query;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class GetCustomerQuery {
    @NotNull(message = "Client ID cannot be null!")
    private UUID customerId;
}
