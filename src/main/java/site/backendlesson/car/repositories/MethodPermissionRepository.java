package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.MethodPermission;

public interface MethodPermissionRepository extends JpaRepository<MethodPermission,Long> {
    MethodPermission findByName(String name);
}
