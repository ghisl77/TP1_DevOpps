package com.example.hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        assertEquals("ABC123", car.getPlateNumber());
        assertEquals("Toyota", car.getBrand());
        assertEquals(15000.0, car.getPrice());
    }

    @Test
    public void testCarSetters() {
        Car car = new Car();
        car.setPlateNumber("XYZ789");
        car.setBrand("Renault");
        car.setPrice(12000.0);

        assertEquals("XYZ789", car.getPlateNumber());
        assertEquals("Renault", car.getBrand());
        assertEquals(12000.0, car.getPrice());
    }

    @Test
    public void testCarPriceIsPositive() {
        Car car = new Car("AA-001-BB", "Peugeot", 9500.0);
        assertTrue(car.getPrice() > 0, "Price should be positive");
    }
}
