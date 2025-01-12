package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
