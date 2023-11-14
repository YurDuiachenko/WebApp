package com.example.springdatabasicdemo.constants;

public enum Engine {

    GASOLIN(0),
    DIESEL(1),
    ELECTRIC(2),
    HYBRID(3);

    private final int value;

    Engine(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
