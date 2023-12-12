package com.example.springdatabasicdemo.web;

import com.example.springdatabasicdemo.dtos.user.AddUsersDto;
import com.example.springdatabasicdemo.dtos.user.UserDto;
import com.example.springdatabasicdemo.dtos.user.UserRegistrationDto;
import com.example.springdatabasicdemo.exeptions.UserNotFoundExeption;
import com.example.springdatabasicdemo.models.Users;
import com.example.springdatabasicdemo.services.UsersService;
import com.example.springdatabasicdemo.services.impl.AuthService;
import com.example.springdatabasicdemo.view.UserProfileView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UsersController {

//    @Autowired
    private UsersService usersService;
    private final AuthService authService;
    public UsersController(AuthService authService) {
        this.authService = authService;
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

    @ModelAttribute("userModel")
    public AddUsersDto initUser() {
        return new AddUsersDto();
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto initForm() {
        return new UserRegistrationDto();
    }

    @PostMapping("/register")
    public String createUser(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);
            return "redirect:/users/register";
        }
        authService.register(userRegistrationDto);

        return "redirect:/users/login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
        @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
        RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("badCredentials", true);
        System.out.println(usersService.getUser(userName));
        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();
        Users users = usersService.getUser(username);

        UserProfileView userProfileView = new UserProfileView(
            users.getUsername(),
            users.getEmail()
        );

        model.addAttribute("user", userProfileView);

        return "profile";
    }



    @Autowired
    public void setUserService(UsersService usersService) {
        this.usersService = usersService;
    }
}
