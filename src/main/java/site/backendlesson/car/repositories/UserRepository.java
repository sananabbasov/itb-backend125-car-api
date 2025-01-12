package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
