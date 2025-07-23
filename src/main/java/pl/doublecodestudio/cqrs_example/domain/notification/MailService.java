package pl.doublecodestudio.cqrs_example.domain.notification;

public interface MailService {
    void sendEmail(String from, String to, String subject);
}
