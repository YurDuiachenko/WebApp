package com.example.springdatabasicdemo.exeptions;

import java.util.UUID;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(UUID id) {
        super("Could not find user - " + id);
    }
}
