package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
import com.example.springdatabasicdemo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UsersController {

//    @Autowired
    private UsersService usersService;
    public UsersController() {
    }

    @GetMapping("/all")
    String all(Model model) {
        model.addAttribute("users", usersService.getAll());
        return "users-all";
    }

    @GetMapping("/{id}")
    Optional<UserDto> get(@PathVariable UUID id) {
        return Optional.ofNullable(usersService.find((id)).orElseThrow(() -> new UserNotFoundExeption(id)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        usersService.destroyById(id);
    }

    @PutMapping("/update")
    UserDto update(@RequestBody UserDto user) {
        return usersService.create(user);
    }

    @PostMapping("/add")
    void add(@RequestBody UserDto user) {
        usersService.addUser(user);
    }

    @Autowired
    public void setUserService(UsersService usersService) {
        this.usersService = usersService;
    }
}
