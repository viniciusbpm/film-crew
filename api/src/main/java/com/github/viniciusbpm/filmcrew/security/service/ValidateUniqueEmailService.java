package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ValidateUniqueEmailService {
    public static final String EMAIL_TAKEN_MESSAGE = "This email is already being used";
    @Autowired
    private UserRepository userRepository;

    public void validate(String email){
        Optional<UserModel> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, EMAIL_TAKEN_MESSAGE);
        }
    }
}
