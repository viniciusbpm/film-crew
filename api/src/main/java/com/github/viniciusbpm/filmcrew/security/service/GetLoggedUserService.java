package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import com.github.viniciusbpm.filmcrew.security.config.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class GetLoggedUserService implements UserDetailsService {
    public static final String NOT_FOUND = "User not found";
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(UserSecurity::new)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }

    public UserModel byEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY,
                NOT_FOUND));
    }
}
