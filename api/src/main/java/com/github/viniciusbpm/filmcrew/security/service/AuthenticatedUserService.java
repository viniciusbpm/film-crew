package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import com.github.viniciusbpm.filmcrew.security.config.UserSecurity;
import com.github.viniciusbpm.filmcrew.security.controller.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.github.viniciusbpm.filmcrew.mapper.UserMapper.toResponse;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class AuthenticatedUserService {
    @Autowired
    private UserRepository userRepository;

    public Long getId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserSecurity) {
            return ((UserSecurity) authentication.getPrincipal()).getId();
        }

        return null;
    }

    public UserModel get() {
        Long id = getId();

        if (isNull(id)) {
            return null;
        }

        return userRepository.findById(getId()).orElse(null);
    }

    public UserResponse getResponse() {
        UserModel entity = get();
        return nonNull(entity) ? toResponse(entity) : new UserResponse();
    }

}
