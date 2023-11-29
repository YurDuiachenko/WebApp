//package com.example.springdatabasicdemo.rest;
//
//import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
//import com.example.springdatabasicdemo.services.UserService;
//import com.example.springdatabasicdemo.services.dtos.UserDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
////    @Autowired
//    private UserService userService;
//
//    public UserController() {}
//
//    @GetMapping("/all")
//    Iterable<UserDto> all() {
//        return userService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    Optional<UserDto> get(@PathVariable UUID id) {
//        return Optional.ofNullable(userService.find((id)).orElseThrow(() -> new UserNotFoundExeption(id)));
//    }
//
//    @DeleteMapping("/{id}")
//    void delete(@PathVariable UUID id) {
//        userService.destroyById(id);
//    }
//
//    @PutMapping("/update")
//    UserDto update(@RequestBody UserDto user) {
//        return userService.create(user);
//    }
//
//    @PostMapping("/add")
//    void add(@RequestBody UserDto user) {
//        userService.addUser(user);
//    }
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//}
