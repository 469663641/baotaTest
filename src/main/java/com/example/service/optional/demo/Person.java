package com.example.service.optional.demo;

import lombok.Data;

import java.util.Optional;

/**
 * Created by baota on 2018/3/31.
 */
@Data
public class Person {

    private Optional<Car> car;

    public Person(Optional<Car> car) {
        this.car = car;
    }
}
