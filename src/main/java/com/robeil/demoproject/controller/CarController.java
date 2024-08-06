package com.robeil.demoproject.controller;

import com.robeil.demoproject.domain.Car;
import com.robeil.demoproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping()
    public List<Car> safAll(@RequestBody List<Car> listCars){
        return service.safeAll(listCars);
    }
    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car){
        return service.save(car);
    }
    @GetMapping("/all")
    public List<Car> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return service.finaAll(page,size);
    }
    @GetMapping("/{id}")
    public Optional<Car> findById(@PathVariable long id){
        return service.findById(id);
    }
    @GetMapping("/brand/{brand}")
    public Optional<Car> findByName(@PathVariable String brand){
        return service.findByBrandName(brand);
    }
}
