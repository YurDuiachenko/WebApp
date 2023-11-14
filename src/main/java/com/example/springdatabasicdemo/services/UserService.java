package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.services.dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    
    UserDto create(UserDto t);

    void addUser(UserDto userDto);

    void destroy(UserDto t);

    void destroyById(UUID id);

    Optional<UserDto> find(UUID id);

    List<UserDto> getAll();
}
