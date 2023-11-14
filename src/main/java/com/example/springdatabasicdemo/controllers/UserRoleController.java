package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.services.dtos.UserRoleDto;
import com.example.springdatabasicdemo.exeptions.UserRoleNotFoundExeption;
import com.example.springdatabasicdemo.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/roles")
public class UserRoleController {

//    @Autowired
    private UserRoleService userRoleService;

    public UserRoleController() {}

    @GetMapping("/roles")
    Iterable<UserRoleDto> all() {
        return userRoleService.getAll();
    }

    @GetMapping("/roles/{id}")
    Optional<UserRoleDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(userRoleService.find((id)).orElseThrow(() -> new UserRoleNotFoundExeption(id)));
    }

    @DeleteMapping("/roles/{id}")
    void delete(@PathVariable UUID id) {
        userRoleService.destroyById(id);
    }

    @PutMapping("/roles")
    UserRoleDto update(@RequestBody UserRoleDto role) {
        return userRoleService.create(role);
    }

    @PostMapping("/roles")
    void add(@RequestBody UserRoleDto userRole) {
        userRoleService.addUserRole(userRole);
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}