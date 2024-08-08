package com.robeil.demoproject.service;

import com.robeil.demoproject.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    long count();
    List<Car> finaAll(int page, int size);
    Optional<Car> findById(long id);
    void delete(Car car);
    Car save(Car car);
    List<Car> safeAll(List<Car> listCars);
    Optional<Car> findByBrandName(String brand);
    void deleteOwner(Car car);
}
