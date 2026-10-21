package taha.learning_project.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;

}
