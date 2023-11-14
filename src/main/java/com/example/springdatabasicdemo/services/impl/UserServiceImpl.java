package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.services.dtos.UserDto;
import com.example.springdatabasicdemo.models.User;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.UserRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import com.example.springdatabasicdemo.services.UserService;
import com.example.springdatabasicdemo.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User s = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.save(s), UserDto.class);
    }

    @Override
    public void addUser(UserDto userDto) {
        if (!this.validationUtil.isValid(userDto)) {

            this.validationUtil
                .violations(userDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        User user = this.modelMapper.map(userDto, User.class);
        user.setRole(modelMapper.map(userRoleService.create(userDto.getRole()), UserRole.class));

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void destroy(UserDto userDto) {
        userRepository.deleteById(userDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
