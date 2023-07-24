package com.github.viniciusbpm.filmcrew.mapper;

import com.github.viniciusbpm.filmcrew.domain.UserModel;
import com.github.viniciusbpm.filmcrew.security.controller.request.UserRequest;
import com.github.viniciusbpm.filmcrew.security.controller.response.UserResponse;

public class UserMapper {
    public static UserResponse toResponse(UserModel user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture())
                .build();
    }

    public static UserModel toEntity(UserRequest request){
        return UserModel.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .profilePicture(request.getProfilePicture())
                .active(true)
                .build();
    }
}
