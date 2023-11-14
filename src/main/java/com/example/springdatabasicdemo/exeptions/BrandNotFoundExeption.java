package com.example.springdatabasicdemo.exeptions;

import java.util.UUID;

public class BrandNotFoundExeption extends RuntimeException {
    public BrandNotFoundExeption(UUID id) {
        super("Could not find brand - " + id);
    }
}
