package pl.doublecodestudio.cqrs_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CqrsExampleApplication {
    private static final Logger logger = LoggerFactory.getLogger(CqrsExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CqrsExampleApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // Logujemy właściwości już z załadowanego kontekstu
        logSpringProperties(context.getEnvironment());
    }
    private static void logSpringProperties(Environment env) {
        logger.info("======== SPRING CONFIG PROPERTIES ========");
        logger.info("spring.profiles.active = {}", env.getProperty("spring.profiles.active"));
        logger.info("spring.datasource.url  = {}", env.getProperty("spring.datasource.url"));
        logger.info("spring.datasource.username = {}", env.getProperty("spring.datasource.username"));
        logger.info("spring.datasource.password = {}", env.getProperty("spring.datasource.password"));
        logger.info("jwt.secret = {}", env.getProperty("jwt.secret"));
        logger.info("mail.username  = {}", env.getProperty("spring.mail.username"));
        logger.info("mail.password  = {}", env.getProperty("spring.mail.password"));
        logger.info("mail.host      = {}", env.getProperty("spring.mail.host"));
        logger.info("mail.port      = {}", env.getProperty("spring.mail.port"));
        logger.info("mail.address   = {}", env.getProperty("mail.address"));
        logger.info("mail.to   = {}", env.getProperty("mail.to"));
        logger.info("spring.rabbitmq.username = {}", env.getProperty("spring.rabbitmq.username"));
        logger.info("spring.rabbitmq.password = {}", env.getProperty("spring.rabbitmq.password"));
        logger.info("==========================================");
    }
}
