package pl.doublecodestudio.cqrs_example.infrastructure.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<JpaCustomerEntity, UUID> {

    Optional<JpaCustomerEntity> findByEmail(String email);
}
