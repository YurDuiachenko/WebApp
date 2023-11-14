package com.example.springdatabasicdemo.exeptions;

import java.util.UUID;

public class UserRoleNotFoundExeption extends RuntimeException {
    public UserRoleNotFoundExeption(UUID id) {
        super("Could not find user role - " + id);
    }
}
