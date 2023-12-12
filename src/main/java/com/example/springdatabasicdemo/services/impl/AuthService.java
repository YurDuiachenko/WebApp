package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.constants.Role;
import com.example.springdatabasicdemo.dtos.user.UserRegistrationDto;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.repositories.UserRoleRepository;
import com.example.springdatabasicdemo.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UsersRepository userRepository;

    private UserRoleRepository roleRepository;


    private PasswordEncoder passwordEncoder;

    public AuthService(UsersRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<Users> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        var userRole = roleRepository.
                findByRole(Role.USER).orElseThrow();

        Users user = new Users(
                registrationDTO.getUserName(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail()
        );
        user.setActive(true);
        user.setRole(userRole);

        this.userRepository.save(user);
    }
}
