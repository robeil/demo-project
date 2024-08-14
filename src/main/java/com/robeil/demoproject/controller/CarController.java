package com.robeil.demoproject.controller;

import com.robeil.demoproject.domain.Car;
import com.robeil.demoproject.exception.MyCustomException;
import com.robeil.demoproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@EnableMethodSecurity
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService service;

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<String> handleCustomException(MyCustomException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @PostMapping()
    public List<Car> safAll(@RequestBody List<Car> listCars){
        return service.safeAll(listCars);
    }
    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car){
        return service.save(car);
    }
    @GetMapping("/all")
    public List<Car> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
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
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public void deleteOwner(Car car){
        service.deleteOwner(car);
    }
}
