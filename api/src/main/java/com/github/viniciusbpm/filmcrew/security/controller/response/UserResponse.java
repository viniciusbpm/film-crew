package com.github.viniciusbpm.filmcrew.security.controller.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String profilePicture;
    private String token;
}
