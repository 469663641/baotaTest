package com.example.service.optional.demo;

import java.util.Optional;

/**
 * Created by baota on 2018/3/31.
 */
public class Client {
    public static void main(String[] args) {
        Insurance insurance = new Insurance();
       insurance.setName("meitu");
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Car car = new Car(optInsurance);
        //car.setInsurance();
        Optional<Car> optCar = Optional.ofNullable(car);

        if (!optCar.isPresent()) {//isPresent()判断是否为null
            return;
        }
        Person person = new Person(optCar);

        String name = person.getCar()
                .flatMap(Car::getInsurance)//将多个option合成一个
                .map(Insurance::getName)
                .orElse("Unknown");//取optional得值
        System.err.println(name);


    }
}
