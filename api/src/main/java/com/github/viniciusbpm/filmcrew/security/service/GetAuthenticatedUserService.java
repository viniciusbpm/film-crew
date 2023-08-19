package com.github.viniciusbpm.filmcrew.security.service;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetAuthenticatedUserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel get(){
        UserModel context = (UserModel) SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();

        return userRepository.findById(context.getId()).get();
    }


}
