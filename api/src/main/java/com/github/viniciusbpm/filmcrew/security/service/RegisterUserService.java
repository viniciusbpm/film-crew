package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.mapper.UserMapper;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import com.github.viniciusbpm.filmcrew.security.controller.request.UserRequest;
import com.github.viniciusbpm.filmcrew.security.controller.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.github.viniciusbpm.filmcrew.mapper.UserMapper.toResponse;

@Service
public class RegisterUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidateUniqueEmailService validateUniqueEmailService;

    @Autowired
    private ValidateUniqueUsernameService validateUniqueUsernameService;

    @Transactional
    public UserResponse register(UserRequest request){
        validateUniqueEmailService.validate(request.getEmail());
        validateUniqueUsernameService.validate(request.getUsername());

        UserModel user = UserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return toResponse(user);
    }
}
