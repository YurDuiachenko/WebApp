package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.repositories.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

public class AppUserDetailsService implements UserDetailsService {
    private UsersRepository userRepository;

    public AppUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName)
                .map(u -> {
                    List<GrantedAuthority> authorities = Collections.singletonList(
                            new SimpleGrantedAuthority("ROLE_" + u.getRole().getRole().name())
                    );
                    System.out.println(1111111);
                    return new User(
                            u.getUsername(),
                            u.getPassword(),
                            authorities
                    );
                })
                .orElseThrow(() -> new UsernameNotFoundException(userName + " was not found!"));
    }

}




