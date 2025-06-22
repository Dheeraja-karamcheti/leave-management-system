package com.dheeraja.leavemanagement.controller;

import com.dheeraja.leavemanagement.model.User;
import com.dheeraja.leavemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUserId(), user.getPassword());
    }
}

