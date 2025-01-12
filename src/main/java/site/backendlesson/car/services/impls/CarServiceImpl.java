package site.backendlesson.car.services.impls;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import site.backendlesson.car.dtos.car.CarDetailDto;
import site.backendlesson.car.dtos.car.CarHomeDto;
import site.backendlesson.car.models.Car;
import site.backendlesson.car.repositories.CarRepository;
import site.backendlesson.car.services.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CarHomeDto> getHomeCars() {
        List<Car> findCars = carRepository.findAll();
        List<CarHomeDto> cars = findCars.stream().map(car -> modelMapper.map(car, CarHomeDto.class)).collect(Collectors.toList());
        cars.forEach(c-> {
            String car  = findCars.stream().flatMap(a->a.getPhotos().stream()).findFirst().get().getUrl();
            c.setPhoto(car);
        });
        return cars;
    }

    @Override
    public CarDetailDto getCarById(Long id) {

        Car findCar = carRepository.findById(id).orElseThrow();
        CarDetailDto car = modelMapper.map(findCar, CarDetailDto.class);
        return car;
    }
}
