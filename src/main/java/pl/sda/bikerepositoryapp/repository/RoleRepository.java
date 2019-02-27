package pl.sda.bikerepositoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bikerepositoryapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
