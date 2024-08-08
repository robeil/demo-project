package com.robeil.demoproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    private int modelYear, price;
    @Column(name="explanation",nullable = false, length = 512)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

    public Car(String brand, String model, String color, String registerNumber, int modelYear, int price, String description, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.description = description;
        this.owner = owner;
    }
}
