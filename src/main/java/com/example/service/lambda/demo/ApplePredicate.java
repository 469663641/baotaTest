package com.example.service.lambda.demo;

/**
 * Created by baota on 2018/4/2.
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}
