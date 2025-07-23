package pl.doublecodestudio.cqrs_example.infrastructure.customer.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "Customer")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JpaCustomerEntity {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;
}
