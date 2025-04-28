package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
