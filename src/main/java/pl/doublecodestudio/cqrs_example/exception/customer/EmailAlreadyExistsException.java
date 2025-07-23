package pl.doublecodestudio.cqrs_example.exception.customer;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends CustomerException {
    public EmailAlreadyExistsException(String email) {
        super(HttpStatus.CONFLICT, "Email already exists: " + email);
    }
}