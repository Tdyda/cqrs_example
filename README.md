# CQRS Example – Spring Boot

This project demonstrates the implementation of the **CQRS (Command Query Responsibility Segregation)** pattern in a **Spring Boot** environment. It includes integration with RabbitMQ, MySQL, JWT handling, mailing, and a layered architecture.

## Project Structure

The project is under the package namespace `pl.doublecodestudio.cqrs_example`.

### Layers:

- **application** – application logic, CQRS commands and queries
- **domain** – entities and ports
- **infrastructure** – external adapters: JPA, RabbitMQ, SMTP
- **security** – JWT support and security configuration
- **exception** – exception handling

## Running the Project

### 1. Local setup (without Docker)

1. Create `application-dev.yml` file.


2. Copy code below and paste to `application-dev.yml`, filling in your own values:

```yaml
server:
  port: 8080

spring:
  application:
    name: cqrs_example

  datasource:
    url: jdbc:mysql://localhost:3306/YOUR_DB_NAME
    username: your_db_user
    password: your_db_password
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

  mail:
    host: smtp.example.com
    port: 587
    username: your_email_user
    password: your_email_password
    properties:
      mail:
        smtp:
          auth: true
          ssl:
            enable: true

  rabbitmq:
    host: rabbitmq
    port: 5672
    username: rabbit_user
    password: rabbit_pass

jwt:
  secret: your_jwt_secret_string

mail:
  address: no-reply@example.com
  to: contact@example.com
```

3. Build the project:

```bash
./mvnw clean install -DskipTests
```

4. Run the application:

```bash
./mvnw spring-boot:run -DskipTests
```

Or run the `CqrsExampleApplication.java` class directly from your IDE (e.g., IntelliJ).

---

### 2. Docker-based setup

1. Navigate to the `docker` directory and copy the `.env.example` file:

```bash
cp ./.env.example ./.env
```

2. Fill in the environment variables in `.env`:

```env
JWT_SECRET=your_jwt_secret_string
SPRING_DATASOURCE_USERNAME=your_user
SPRING_DATASOURCE_PASSWORD=your_pass
MYSQL_DATABASE=your_db
MYSQL_ROOT_PASSWORD=root_pass
MAIL_USER=your_email_user
MAIL_PASS=your_email_password
MAIL_HOST=smtp.example.com
MAIL_PORT=587
MAIL_ADDRESS=no-reply@example.com
MAIL_TO=contact@example.com
RABBITMQ_USER=rabbit_user
RABBITMQ_PASS=rabbit_pass
```

3. Run the project:

```bash
make build
```

## Requirements

- Java 17+
- Maven
- MySQL
- RabbitMQ
- SMTP (for mailing)
- Docker (optional)

## Authors

Demo project developed by Tomasz Dyda.