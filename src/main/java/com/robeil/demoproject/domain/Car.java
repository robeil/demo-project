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
}
