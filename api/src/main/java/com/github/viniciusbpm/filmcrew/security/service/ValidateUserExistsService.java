package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateUserExistsService {
    @Autowired
    private UserRepository userRepository;

    public void validate(String username){

    }
}
