package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.services.dtos.UserDto;
import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/users")
public class UserController {

//    @Autowired
    private UserService userService;

    public UserController() {}

    @GetMapping("/users")
    Iterable<UserDto> all() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    Optional<UserDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(userService.find((id)).orElseThrow(() -> new UserNotFoundExeption(id)));
    }

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable UUID id) {
        userService.destroyById(id);
    }

    @PutMapping("/users")
    UserDto update(@RequestBody UserDto user) {
        return userService.create(user);
    }

    @PostMapping("/users")
    void add(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
