package pl.doublecodestudio.cqrs_example.interfaces.web.customer.mapper;

import org.mapstruct.Mapper;
import pl.doublecodestudio.cqrs_example.domain.customer.entity.Customer;
import pl.doublecodestudio.cqrs_example.interfaces.web.customer.dto.CustomerResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto toDto(Customer customer);

    List<CustomerResponseDto> toDto(List<Customer> customers);
}