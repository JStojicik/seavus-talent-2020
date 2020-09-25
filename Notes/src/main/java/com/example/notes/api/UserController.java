package com.example.notes.api;

import com.example.notes.model.User;
import com.example.notes.security.SecurityService;
import com.example.notes.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findUsers();
    }

    @GetMapping("/me")
    public User findAuthenticatedCustomer() {
        return securityService.getAuthenticatedCustomer();
    }
}
