package site.backendlesson.car.services;

import aj.org.objectweb.asm.commons.Remapper;
import site.backendlesson.car.models.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(String username);
    boolean removeToken(String email);
    Optional<RefreshToken> findByToken(String token);
    RefreshToken verifyExpiration(RefreshToken token);
}
