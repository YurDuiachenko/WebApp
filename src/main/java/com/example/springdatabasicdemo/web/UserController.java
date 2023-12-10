package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
import com.example.springdatabasicdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

//    @Autowired
    private UserService userService;

    public UserController() {}

    @GetMapping("/all")
    String all(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users-all";
    }

    @GetMapping("/{id}")
    Optional<UserDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(userService.find((id)).orElseThrow(() -> new UserNotFoundExeption(id)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        userService.destroyById(id);
    }

    @PutMapping("/update")
    UserDto update(@RequestBody UserDto user) {
        return userService.create(user);
    }

    @PostMapping("/add")
    void add(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
