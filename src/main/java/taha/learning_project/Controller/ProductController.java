package taha.learning_project.Controller;

import org.springframework.web.bind.annotation.RestController;

import taha.learning_project.DTO.ProductDTO;
import taha.learning_project.Entity.Product;
import taha.learning_project.Service.ProductService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public String getProductByName(@RequestParam String name, @RequestParam String id) {
        return "Product name: " + name + "\n Product id: " + id;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveAndReturnProductDTO(productDTO);
    }

    // @PutMapping("/{id}")
    // public String updateProduct(@PathVariable String id) {
    // return "Product" + id + "Updated!";
    // }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID id) {
        productService.deleteProductById(id);
    }

}
