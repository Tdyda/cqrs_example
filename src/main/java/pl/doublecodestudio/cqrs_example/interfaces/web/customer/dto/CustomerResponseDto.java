package pl.doublecodestudio.cqrs_example.interfaces.web.customer.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CustomerResponseDto {
    private UUID id;
    private String name;
    private String email;
}
