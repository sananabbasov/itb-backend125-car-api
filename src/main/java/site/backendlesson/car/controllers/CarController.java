package site.backendlesson.car.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.backendlesson.car.dtos.car.CarDetailDto;
import site.backendlesson.car.dtos.car.CarHomeDto;
import site.backendlesson.car.models.Car;
import site.backendlesson.car.services.CarService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CarHomeDto>> getAll(){
        List<CarHomeDto> cars = carService.getHomeCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<CarDetailDto> getDetail(@PathVariable Long id){
        CarDetailDto carDetail = carService.getCarById(id);
        return new ResponseEntity<>(carDetail, HttpStatus.OK);
    }


}
