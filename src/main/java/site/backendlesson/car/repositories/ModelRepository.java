package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.Model;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
