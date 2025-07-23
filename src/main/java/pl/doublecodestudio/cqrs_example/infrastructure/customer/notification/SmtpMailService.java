package pl.doublecodestudio.cqrs_example.infrastructure.customer.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.doublecodestudio.cqrs_example.domain.notification.MailService;


@Slf4j
@Service
@RequiredArgsConstructor
public class SmtpMailService implements MailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String from, String to, String subject) {
        log.info("Sending email to {}: {}", to, subject);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText("Utworzono nowego customer");
        try {
            log.info("About to send mail to {}", to);
            mailSender.send(message);
            log.info("Mail sent successfully to {}", to);
        } catch (Exception e) {
            log.error("Error sending mail to {}: {}", to, e.getMessage(), e);
        }
    }
}
