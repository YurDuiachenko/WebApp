package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.role.UserRoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserRoleService{

    UserRoleDto create(UserRoleDto t);

    void addUserRole(UserRoleDto userRoleDto);

    void destroy(UserRoleDto t);

    void destroyById(UUID id);

    Optional<UserRoleDto> find(UUID id);

    List<UserRoleDto> getAll();
}
