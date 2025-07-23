package pl.doublecodestudio.cqrs_example.domain.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer {
    private UUID id;
    private String name;
    private String email;
}