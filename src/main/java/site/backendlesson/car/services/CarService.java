package site.backendlesson.car.services;

import site.backendlesson.car.dtos.car.CarDetailDto;
import site.backendlesson.car.dtos.car.CarHomeDto;

import java.util.List;

public interface CarService {
    List<CarHomeDto> getHomeCars();
    CarDetailDto getCarById(Long id);
}
