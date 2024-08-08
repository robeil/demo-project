package com.robeil.demoproject;

import com.robeil.demoproject.domain.AppUser;
import com.robeil.demoproject.domain.Car;
import com.robeil.demoproject.domain.Owner;
import com.robeil.demoproject.repository.AppUserRepository;
import com.robeil.demoproject.repository.CarRepository;
import com.robeil.demoproject.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DemoProjectApplication.class);
    private final CarRepository repository;
    private final OwnerRepository orepository;
    private final AppUserRepository urepository;


public DemoProjectApplication(
        CarRepository repository,
        OwnerRepository orepository,
        AppUserRepository urepository) {
    this.repository = repository;
    this.orepository = orepository;
    this.urepository = urepository;
}
    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
        logger.info("After adding this comment the application is restarted");
    }
    @Override
    public void run(String... args) throws Exception {

//
//        Owner owner1 = new Owner("John", "Johnson");
//        Owner owner2 = new Owner("Mary", "Robinson");
//        orepository.saveAll(Arrays.asList(owner1, owner2));
//        repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, "Car",owner1));
//        repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000,"Car", owner2));
//        repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000,"Car", owner2));
//// Fetch all cars and log to console
//        for (Car car : repository.findAll()) {
//            logger.info(car.getBrand() + " " + car.getModel());
//         }
//
//    urepository.save(new AppUser("user", "user","USER"));
//    urepository.save(new AppUser("admin", "admin", "ADMIN"));
    }


}
