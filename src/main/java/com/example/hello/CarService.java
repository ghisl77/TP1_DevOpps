package com.example.hello;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("AB-123-CD", "Toyota", 15000.0));
        cars.add(new Car("EF-456-GH", "Renault", 12000.0));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car getCarByPlate(String plateNumber) {
        return cars.stream()
                .filter(c -> c.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null);
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
