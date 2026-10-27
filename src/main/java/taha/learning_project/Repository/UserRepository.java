package taha.learning_project.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import taha.learning_project.Entity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {

}
