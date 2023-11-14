package com.example.springdatabasicdemo.constants;

public enum Category{
    CAR(0),
    BUSS(1),
    TRUCK(2),
    MOTORCYCLE(3);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};