package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
