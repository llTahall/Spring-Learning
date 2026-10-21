package taha.learning_project.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import taha.learning_project.Entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, UUID> {

}
