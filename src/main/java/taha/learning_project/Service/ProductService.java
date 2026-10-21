package taha.learning_project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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

    public List<ProductDTO> getProducts() {

        List<Product> products = productRepository.findAll(); // GET DATA FROM DB
        List<ProductDTO> productsDTO = new ArrayList<>(); // DECLARE EMPTY DTO LIST

        for (Product p : products) {
            productsDTO.add(productMapper.convertToProductDTO(p)); // CONVERT -> DTO
        }
        return productsDTO;
    }

    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.convertToProductDTO(product);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO, UUID id) {

        Product product = productRepository.findById(id).orElseThrow(); //GET ROW

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());

        return productMapper.convertToProductDTO(product);
    }
}
