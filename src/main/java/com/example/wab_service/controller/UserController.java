package com.example.wab_service.controller;

import com.example.wab_service.model.UserSignUpRequest;
import com.example.wab_service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void crate(
            @RequestBody UserSignUpRequest userRequest
    ) {
        return userService.creat(userRequest);
    }
}
