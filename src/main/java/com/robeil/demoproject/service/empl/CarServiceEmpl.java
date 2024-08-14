package com.robeil.demoproject.service.empl;

import com.robeil.demoproject.domain.Car;
import com.robeil.demoproject.repository.CarRepository;
import com.robeil.demoproject.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceEmpl implements CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository repository;
    @Override
    public long count() {
        logger.info("Count of Car in DB :  {}, " + repository.count() );
        return repository.count();
    }
    @Cacheable("cars")
    @Override
    public List<Car> finaAll(int page, int size) {
        logger.info("FindAll:  {}" );
        Pageable pageable = PageRequest.of(page, size);
        var allCars = repository.findAll(pageable);
        return repository.findAll();
    }

    @Override
    public Optional<Car> findById(long id) {
        logger.info("FindByID:  {}" + id);
        var optionalCar = repository.findById(id);
        if(optionalCar.isPresent()){
            logger.info("No such Car found with the id {} " + id);
        }
        return optionalCar;
    }

    @Override
    public void delete(Car car) {
        logger.info("delete :  {}" + car.toString());
        repository.delete(car);
    }

    @Override
    public Car save(Car car) {
        logger.info("save:  {}" + car.toString());
        return repository.save(car);
    }

    @Override
    public List<Car> safeAll(List<Car> listCars) {
        logger.info("saveAll:  {}" );
        return repository.saveAll(listCars);
    }

    @Cacheable("cars")
    @Override
    public Optional<Car> findByBrandName(String brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public void deleteOwner(Car car) {
        var carExists = repository.findById(car.getId());
        if(carExists.isPresent()){
            carExists.get().setOwner(null);
        }else{
            logger.info("There is no Owner found that own the given car details : " + car);
        }
    }
}
