package taha.learning_project.Entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(value = AccessLevel.NONE)
    private UUID id;

    @NotBlank()
    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private double price;

    @PositiveOrZero
    @Column(nullable = false)
    private int quantity;

    public Product(@NotBlank String name, String description, double price, @PositiveOrZero int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
