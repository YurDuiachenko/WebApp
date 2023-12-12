package com.example.springdatabasicdemo.exeptions;

public class UsersConflictException extends RuntimeException {
    public UsersConflictException(String message) {
        super(message);
    }
}
