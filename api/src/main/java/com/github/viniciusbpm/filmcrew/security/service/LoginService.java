package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.mapper.UserMapper;
import com.github.viniciusbpm.filmcrew.security.controller.request.LoginRequest;
import com.github.viniciusbpm.filmcrew.security.controller.request.UserRequest;
import com.github.viniciusbpm.filmcrew.security.controller.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid email or password";

    public UserResponse login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        try{
        Authentication authentication =
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (UserModel) authentication.getPrincipal();

        UserResponse response = UserMapper.toResponse(user);
        response.setToken(tokenService.generateToken(user));

        return response;
        } catch (Exception e){
            throw new ResponseStatusException(BAD_REQUEST, INVALID_CREDENTIALS_MESSAGE);
        }
    }
}
