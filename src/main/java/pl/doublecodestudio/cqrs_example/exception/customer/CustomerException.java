package pl.doublecodestudio.cqrs_example.exception.customer;

import org.springframework.http.HttpStatus;
import pl.doublecodestudio.cqrs_example.exception.ApiException;

public class CustomerException extends ApiException {
    public CustomerException(HttpStatus status, String message) {
        super(status, message);
    }
}