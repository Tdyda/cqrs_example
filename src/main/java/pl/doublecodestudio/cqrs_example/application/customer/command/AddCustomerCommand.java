package pl.doublecodestudio.cqrs_example.application.customer.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AddCustomerCommand {
    @NotBlank(message = "Name cannot be blank!")
    private final String name;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Incorrect email address format")
    private final String email;
}
