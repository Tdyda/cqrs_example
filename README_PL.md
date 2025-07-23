# CQRS Example – Spring Boot

Ten projekt demonstruje implementację wzorca CQRS (Command Query Responsibility Segregation) w środowisku **Spring Boot**. Zawiera integrację z RabbitMQ, MySQL oraz obsługę JWT, mailing i rozbudowaną architekturę opartą na warstwach.

## Zawartość projektu

Projekt znajduje się w przestrzeni pakietowej `pl.doublecodestudio.cqrs_example`.

### Warstwy:

- **application** – logika aplikacyjna, komendy i zapytania CQRS
- **domain** – encje i porty
- **infrastructure** – adaptery zewnętrzne: JPA, RabbitMQ, SMTP
- **security** – obsługa JWT, konfiguracja bezpieczeństwa
- **exception** – obsługa wyjątków

## Uruchomienie projektu

### 1. Konfiguracja lokalna (bez Dockera)

1. Utwórz plik konfiguracyjny `application-dev.yml`:


2. Skopiuj poniższy kod i wklej go do `application-dev.yml`, uzupełniając własne dane:

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

3. Zbuduj projekt:

```bash
./mvnw clean install -DskipTests
```

4. Uruchom aplikację:

```bash
./mvnw spring-boot:run -DskipTests
```

Lub z poziomu IDE (np. IntelliJ) uruchom klasę `CqrsExampleApplication.java`.

---

### 2. Konfiguracja z Dockerem

1. Przejdź do katalogu `docker` i skopiuj plik `.env.example`:

```bash
cp ./.env.example ./.env
```

2. Uzupełnij zmienne środowiskowe w `.env`:

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

3. Uruchom projekt:

```bash
make build
```

## Wymagania

- Java 17+
- Maven
- MySQL
- RabbitMQ
- SMTP (jeśli testujesz mailing)
- Docker (opcjonalnie)

## Autorzy

Projekt demonstracyjny opracowany przez Tomasz Dyda.