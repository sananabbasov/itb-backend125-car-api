package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    Optional<RefreshToken> findByUserId(Long id);
}
