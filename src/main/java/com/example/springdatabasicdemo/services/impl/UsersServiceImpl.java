package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.exeptions.UsersConflictException;
import com.example.springdatabasicdemo.exeptions.UsersNotFoundException;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
import com.example.springdatabasicdemo.services.UsersService;
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
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private UserRoleService userRoleService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UsersServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto registerUser(UserDto users) {

        if (!this.validationUtil.isValid(users)) {
            this.validationUtil
                .violations(users)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
            throw new IllegalArgumentException("не подходит");
        }

        Users u = modelMapper.map(users, Users.class);
        UUID userId = u.getId();
        if (u.getId() == null || usersRepository.findById(userId).isEmpty()) {
            return modelMapper.map(usersRepository.save(u), UserDto.class);
        } else {
            throw new UsersConflictException("уже существует с таким id");
        }
    }

    @Override
    public UserDto create(UserDto userDto) {
        Users s = modelMapper.map(userDto, Users.class);
        return modelMapper.map(usersRepository.save(s), UserDto.class);
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

        Users users = this.modelMapper.map(userDto, Users.class);
        users.setRole(modelMapper.map(userRoleService.create(userDto.getRole()), UserRole.class));

        this.usersRepository.saveAndFlush(users);
    }

    public Users getUser(String username) {
        System.out.println(username);
        return usersRepository.findByUsername(username)
            .orElseThrow(() -> new UsersNotFoundException(username + " was not found!"));
    }

    @Override
    public void destroy(UserDto userDto) {
        usersRepository.deleteById(userDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UserDto.class));
    }

    @Override
    public List<UserDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UserDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
