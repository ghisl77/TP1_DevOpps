package com.example.hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    @Test
    public void testGetAllCars() {
        CarService service = new CarService();
        assertNotNull(service.getAllCars());
        assertFalse(service.getAllCars().isEmpty(), "Car list should not be empty");
    }

    @Test
    public void testGetCarByPlate() {
        CarService service = new CarService();
        Car car = service.getCarByPlate("AB-123-CD");
        assertNotNull(car, "Should find car with plate AB-123-CD");
        assertEquals("Toyota", car.getBrand());
    }

    @Test
    public void testGetCarByPlateNotFound() {
        CarService service = new CarService();
        Car car = service.getCarByPlate("UNKNOWN");
        assertNull(car, "Should return null for unknown plate");
    }

    @Test
    public void testAddCar() {
        CarService service = new CarService();
        int initialSize = service.getAllCars().size();
        service.addCar(new Car("ZZ-999-ZZ", "BMW", 30000.0));
        assertEquals(initialSize + 1, service.getAllCars().size());
    }
}
