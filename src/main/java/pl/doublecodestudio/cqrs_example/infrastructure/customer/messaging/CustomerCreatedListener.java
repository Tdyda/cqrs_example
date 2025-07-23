package pl.doublecodestudio.cqrs_example.infrastructure.customer.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.doublecodestudio.cqrs_example.infrastructure.customer.notification.SmtpMailService;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerCreatedListener {
    private final SmtpMailService mailService;

    @Value("${mail.address}")
    private String mailAddres;

    @Value("${mail.to}")
    private String mailTo;

    @RabbitListener(queues = "customer-notification-queue")
    public void onCustomerCreated(CustomerCreatedEvent event) {
        log.info("Otrzymano event o nowym kliencie: {}", event);
        mailService.sendEmail(mailAddres, mailTo, "test");
    }
}

