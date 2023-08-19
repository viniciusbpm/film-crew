package com.github.viniciusbpm.filmcrew.security.controller;

import com.github.viniciusbpm.filmcrew.security.controller.request.LoginRequest;
import com.github.viniciusbpm.filmcrew.security.controller.request.UserRequest;
import com.github.viniciusbpm.filmcrew.security.controller.response.UserResponse;
import com.github.viniciusbpm.filmcrew.security.service.LoginService;
import com.github.viniciusbpm.filmcrew.security.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return registerUserService.register(request);
    }

}
