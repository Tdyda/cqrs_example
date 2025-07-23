package pl.doublecodestudio.cqrs_example.infrastructure.customer.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CustomerCreatedEvent {
    private UUID id;
    private String name;
    private String email;
}
