package com.example.springdatabasicdemo.exeptions;

import java.util.UUID;

public class OfferNotFoundExeption extends RuntimeException {
    public OfferNotFoundExeption(UUID id) {
        super("Could not find offer - " + id);
    }
}
