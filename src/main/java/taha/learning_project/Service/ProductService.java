package taha.learning_project.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Null;
import taha.learning_project.DTO.ProductDTO;
import taha.learning_project.Entity.Product;
import taha.learning_project.Mapper.ProductMapper;
import taha.learning_project.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDTO saveAndReturnProductDTO(ProductDTO productDTO) {
        Product product = productMapper.convertToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.convertToProductDTO(savedProduct);
    }

    public List<Product> getProducts() {

        return productRepository.findAll();

    }

    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.convertToProductDTO(product);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }
}
