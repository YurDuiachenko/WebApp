package com.example.springdatabasicdemo.exeptions;

import java.util.UUID;

public class ModelNotFoundExeption extends RuntimeException {
    public ModelNotFoundExeption(UUID id) {
        super("Could not find brand - " + id);
    }
}
