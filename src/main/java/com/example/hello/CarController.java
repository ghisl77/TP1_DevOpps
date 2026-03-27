package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{plate}")
    public Car getCarByPlate(@PathVariable String plate) {
        return carService.getCarByPlate(plate);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }
}
