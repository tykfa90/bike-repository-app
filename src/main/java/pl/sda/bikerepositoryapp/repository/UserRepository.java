package pl.sda.bikerepositoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bikerepositoryapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
