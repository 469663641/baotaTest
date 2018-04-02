package com.example.service.optional.demo;

import lombok.Data;

import java.util.Optional;

/**
 * Created by baota on 2018/3/31.
 */
@Data
public class Car {
    private Optional<Insurance> insurance;

    public Car(Optional<Insurance> optInsurance){
        this.insurance = optInsurance;

    }
}
