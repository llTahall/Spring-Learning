package taha.learning_project.Mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import taha.learning_project.DTO.ProductDTO;
import taha.learning_project.Entity.Product;

@Component
public class ProductMapper {

    public ProductDTO convertToProductDTO(Product product) {

        // les exceptions a gerer plus tard !!!
        UUID id = product.getId();
        String name = product.getName();
        double price = product.getPrice();
        int quantity = product.getQuantity();
        String description = product.getDescription();
        ProductDTO productDTO = new ProductDTO(id, name, description, price, quantity);

        return productDTO;

    }

    public Product convertToProduct(ProductDTO productDTO) {

        // les exceptions a gerer plus tard !!!
        String name = productDTO.getName();
        double price = productDTO.getPrice();
        int quantity = productDTO.getQuantity();
        String description = productDTO.getDescription();
        Product product = new Product(name, description, price, quantity);

        return product;

    }
}
