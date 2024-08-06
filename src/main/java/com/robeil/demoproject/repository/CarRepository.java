package com.robeil.demoproject.repository;

import com.robeil.demoproject.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.brand = ?1")
    Optional<Car> findByBrand(String brand);
}
