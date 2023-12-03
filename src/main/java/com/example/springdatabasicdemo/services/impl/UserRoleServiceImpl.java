package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.role.UserRoleDto;
import com.example.springdatabasicdemo.models.UserRole;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.services.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserRoleServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserRoleDto create(UserRoleDto UserRoleDto) {
        UserRole s = modelMapper.map(UserRoleDto, UserRole.class);
        return modelMapper.map(userRoleRepository.save(s), UserRoleDto.class);
    }

    @Override
    public void addUserRole(UserRoleDto userRoleDto) {
        if (!this.validationUtil.isValid(userRoleDto)) {

            this.validationUtil
                .violations(userRoleDto)
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(System.out::println);
        } else {
            this.userRoleRepository
                .saveAndFlush(this.modelMapper
                    .map(userRoleDto, UserRole.class));

        }
    }

    @Override
    public void destroy(UserRoleDto UserRoleDto) {
        userRoleRepository.deleteById(UserRoleDto.id());
    }

    @Override
    public void destroyById(UUID id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public Optional<UserRoleDto> find(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class));
    }

    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((s) -> modelMapper.map(s, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
