package site.backendlesson.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.backendlesson.car.models.Car;

public interface CarRepository  extends JpaRepository<Car, Long> {
}
