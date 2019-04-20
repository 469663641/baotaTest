package com.example.service.lambda.demo;

import lombok.Data;

/**
 * Created by baota on 2018/4/2.
 */
@Data
public class Apple {
    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {

    }

    private Integer weight;
    private String color;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //public Apple(){}
}
