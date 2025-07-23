package pl.doublecodestudio.cqrs_example.interfaces.web.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/error")
    public String triggerError() {
        throw new RuntimeException("Coś poszło bardzo nie tak!");
    }
}
