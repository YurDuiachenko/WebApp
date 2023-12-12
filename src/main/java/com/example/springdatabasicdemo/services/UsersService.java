package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.models.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UsersService {

    UserDto registerUser(UserDto users);
    UserDto create(UserDto t);

    Users getUser(String username);

    void addUser(UserDto userDto);

    void destroy(UserDto t);

    void destroyById(UUID id);

    Optional<UserDto> find(UUID id);

    List<UserDto> getAll();
}
